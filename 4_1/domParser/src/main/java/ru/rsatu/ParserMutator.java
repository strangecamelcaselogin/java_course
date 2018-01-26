package ru.rsatu;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserMutator {
    public void parseRecourseNodes(Node node) {

        if (node.getNodeName().equals("#text"))
            return;
        //имя тега
        System.out.println("<" + node.getNodeName());
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
            String content = parseElementContent(node);

            if (content != null && !(content.equals(""))) {
                System.out.println("Text content = '" + content + "'\n");
            }
        } catch (NullPointerException e) {
            System.out.println("No content");
        }

        NodeList nodeList = node.getChildNodes();

        //рекурсивно вызываем метод для каждого из подэлементов в переданном узле
        for (int i = 0; i < nodeList.getLength(); i++){
            parseRecourseNodes(nodeList.item(i));
        }
    }

    private String parseElementContent(Node node) {

        Node contentNode = node.getFirstChild();
        if (contentNode != null)

            if (contentNode.getNodeName().equals("#text")) {
                String value = contentNode.getNodeValue();

                if (value != null) {
                    if (value.equals("Философия")) {
                        contentNode.setTextContent("Логика и философия");
                    }

                    if (value.equals("???")) {
                        contentNode.setTextContent("ИВС-17");
                    }

                    return value.trim();
                }
            }
        return null;
    }
}
