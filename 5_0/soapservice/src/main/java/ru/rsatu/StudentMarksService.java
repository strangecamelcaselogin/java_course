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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class StudentMarksService {
    private Document document;

    public StudentMarksService() {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();

            URL documentURL = this.getClass().getClassLoader().getResource("university.xml");

            if (documentURL == null) {
                throw new FileNotFoundException("university.xml Not Found in Resources directory");
            }

            // Создается дерево DOM документа из файла
            this.document = documentBuilder.parse(documentURL.toString());

        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new ParsingException("Can not initialize StudentMarksService", e);
        }
    }

    public Subjects getMarks(String university,
                             String faculty,
                             String groupName,
                             String firstName,
                             String lastName) {

        XPath xPath = XPathFactory.newInstance().newXPath();

        try {
            NodeList subjects = (NodeList) xPath.
                    compile(String.format("//university[universityName='%s']" +
                            "/faculty[facultyName='%s']" +
                            "/departments" +
                            "/department" +
                            "/groups" +
                            "/group[groupName='%s']" +
                            "/students" +
                            "/student[firstname='%s' and surname='%s']" +
                            "/subjects",
                            university.toLowerCase(),
                            faculty.toLowerCase(),
                            groupName.toLowerCase(),
                            firstName.toLowerCase(),
                            lastName.toLowerCase()))

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
                                xmlSubject.setSubjectName(t.getFirstChild().getNodeValue());
                            }
                            if (t.getNodeName().equals("mark")) {
                                xmlSubject.setMark(t.getFirstChild().getNodeValue());
                            }
                        }

                        xmlSubjects.getSubjects().add(xmlSubject);
                    }
                }

                return xmlSubjects;

            } else {
                System.out.println("Студент не найден");
                return null;
            }
        }
        catch (XPathExpressionException e) {
            System.out.println("Ошибка XPath\n" + e.toString());
            return null;
        }
    }
}
