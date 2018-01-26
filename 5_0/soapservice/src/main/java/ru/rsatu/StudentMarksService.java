package ru.rsatu;

import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ru.rsatu.Subjects;
import ru.rsatu.Subject;

public class StudentMarksService {
    private Document document;

    public StudentMarksService() throws ParserConfigurationException, IOException, SAXException {
        // Создается построитель документа
        DocumentBuilder documentBuilder = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder();
        // Создается дерево DOM документа из файла

        URL documentURL = this.getClass().getClassLoader().getResource("university.xml");

        if (documentURL == null) {
            throw new RuntimeException("university.xml Not Found in Resources");
        }

        this.document = documentBuilder.parse(documentURL.toString());
    }

    public Subjects getMarks(String groupName, String firstName, String lastName) {
        XPath xPath = XPathFactory.newInstance().newXPath();

        try {
            NodeList subjects = (NodeList) xPath.
                    compile(String.format("//university[universityName='РГАТУ']" +
                            "/faculty[facultyName='ФРЕИ']" +
                            "/departments" +
                            "/department" +
                            "/groups" +
                            "/group[groupName='%s']" +
                            "/students" +
                            "/student[firstname='%s' and surname='%s']" +
                            "/subjects", groupName, firstName, lastName))
                    .evaluate(document, XPathConstants.NODE);

            if (subjects != null) {
                Subjects xmlSubjects = new Subjects();

                for (int i = 0; i < subjects.getLength(); i++) {
                    Node subject = ((DeferredElementImpl) subjects).getChildNodes().item(i);
                    if (subject.getNodeName().equals("subject")) {
                        NodeList subjectChilds = subject.getChildNodes();

                        Subject xmlSubject = new Subject();
                        for (int j = 0; j < subjectChilds.getLength(); j ++) {
                            Node t = subjectChilds.item(j);
                            if (t.getNodeName().equals("subjectName")) {
                                System.out.println(t.getFirstChild().getNodeValue());
                                xmlSubject.setSubjectName(t.getFirstChild().getNodeValue());
                            }
                            if (t.getNodeName().equals("mark")) {
                                System.out.println(t.getFirstChild().getNodeValue());
                                xmlSubject.setMark(t.getFirstChild().getNodeValue());
                            }
                        }

                        xmlSubjects.getSubject().add(xmlSubject);
                    }
                }

                return xmlSubjects;

            } else {
                System.out.println("Студент не найден");
                return null;
            }
        }
        catch (XPathExpressionException e) {
            return null;
        }
    }
}
