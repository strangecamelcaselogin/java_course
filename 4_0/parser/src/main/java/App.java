import java.io.IOException;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class App {

    public static void main(String[] args) {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("university.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("List of foods:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList foods = root.getChildNodes();
            for (int i = 0; i < foods.getLength(); i++) {
                Node food = foods.item(i);
                // Если нода не текст, то это книга - заходим внутрь
                if (food.getNodeType() != Node.TEXT_NODE) {
                    NodeList foodProps = food.getChildNodes();
                    for(int j = 0; j < foodProps.getLength(); j++) {
                        Node foodProp = foodProps.item(j);
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (foodProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(foodProp.getNodeName() + ":" + foodProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }

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
}
