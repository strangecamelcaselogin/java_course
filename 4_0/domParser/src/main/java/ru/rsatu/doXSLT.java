package ru.rsatu;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class doXSLT {
    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, TransformerConfigurationException, TransformerException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        File stylesheet = new File("new_form.xsl");
        File datafile = new File("university.xml");

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(datafile);
        // ...
        TransformerFactory tFactory = TransformerFactory.newInstance();
        StreamSource stylesource = new StreamSource(stylesheet);
        Transformer transformer = tFactory.newTransformer(stylesource);

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }
}
