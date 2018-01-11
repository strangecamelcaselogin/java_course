import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bdepartament = false;
                boolean bgroup = false;
                boolean bsurname = false;
                boolean bsubject = false;
                boolean bname_subject = false;
                boolean bmark_subject = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {


                    if (qName.equalsIgnoreCase("Departamnet_name")) {
                        bdepartament = true;
                    }

                    if (qName.equalsIgnoreCase("Group_name")) {
                        bgroup = true;
                    }

                    if (qName.equalsIgnoreCase("Surname")) {
                        bsurname = true;
                    }

                    if (qName.equalsIgnoreCase("Subject")) {
                        bsubject = true;
                    }

                    if (qName.equalsIgnoreCase("Name") && bsubject) {
                        bname_subject = true;
                    }

                    if (qName.equalsIgnoreCase("Mark") && bsubject) {
                        bmark_subject = true;
                    }

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bdepartament) {
                        System.out.println("Departamnet : " + new String(ch, start, length));
                        bdepartament = false;
                    }

                    if (bgroup) {
                        System.out.println("Group : " + new String(ch, start, length));
                        bgroup = false;
                    }

                    if (bsurname) {
                        System.out.println("Surname : " + new String(ch, start, length));
                        bsurname = false;
                    }

                    if (bname_subject) {
                        System.out.println("Subject : " + new String(ch, start, length));
                        bname_subject = false;
                    }

                    if (bmark_subject) {
                        System.out.println("Mark : " + new String(ch, start, length));
                        bmark_subject = false;
                        bsubject = false;
                    }

                }

            };

            saxParser.parse("university.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

