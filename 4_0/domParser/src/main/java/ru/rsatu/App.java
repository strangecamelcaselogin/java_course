package ru.rsatu;

import java.io.IOException;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


public class App {

    public static void main(String[] args) throws XPathExpressionException{
        try {
            // Создается построитель документа

            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            Schema schema = factory.newSchema(new File("university.xsd"));

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("university.xml");

            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));

            // Получаем корневой элемент
            Node root = document.getDocumentElement();
            getRecourseNodes(root);

            System.out.println("List of students:");
            System.out.println();

            XPath xPath = XPathFactory.newInstance().newXPath();
            Node nameNode = (Node) xPath.compile("/university/universityName").evaluate(document, XPathConstants.NODE);
            nameNode.setTextContent("МГУ");


            //это магия
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("file.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }  catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    private static void getRecourseNodes(Node node) {

        if (node.getNodeName().equals("#text"))
            return;
        //имя тега
        System.out.println(node.getNodeName());
        //атрибуты тега
        NamedNodeMap nodeMap = node.getAttributes();

        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i ++){
                System.out.println("Attribute " + nodeMap.item(i).getNodeName()
                        + " = " + nodeMap.item(i).getNodeValue());
            }
        }

        //содержимое элемента
        try {
            if (getElementContent(node) != null && !(getElementContent(node).equals("")))
                System.out.println("Text content = '" + getElementContent(node) + "'\n");
        } catch (NullPointerException e) {
            System.out.println("No content");
        }

        NodeList nodeList = node.getChildNodes();

        //рекурсивно вызываем метод для каждого из подэлементов в переданном узле
        for (int i = 0; i < nodeList.getLength(); i++){
            getRecourseNodes(nodeList.item(i));
        }
    }

    private static String getElementContent(Node node) {

        Node contentNode = node.getFirstChild();
        if (contentNode != null)

            if (contentNode.getNodeName().equals("#text")) {
                String value = contentNode.getNodeValue();
                if (value != null)
                    return value.trim();
                try {
                    if (value.equals("Философия")) {
                        contentNode.setTextContent("Логика и философия");
                    }

                    if (value.equals("???")) {
                        contentNode.setTextContent("ИВМ-17");
                    }
                } catch (NullPointerException e){
                    System.out.println("Maybe its NullPointer");
                }
            }
        return null;
    }
    //System.out.println(foodProp.getNodeName() + ":" + foodProp.getChildNodes().item(0).getTextContent());
}
