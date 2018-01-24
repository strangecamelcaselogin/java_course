package ru.rsatu;

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

                boolean buniversity = false;
                boolean buniversityname = false;
                boolean bfaculty = false;
                boolean bfacultyname = false;
                boolean bdepartments = false;
                boolean bdepartment = false;
                boolean bdepartamentname = false;
                boolean bgroups = false;
                boolean bgroup = false;
                boolean bgroupname = false;
                boolean bsudents = false;
                boolean bstudent = false;
                boolean bfirstname = false;
                boolean bsurname = false;
                boolean bsubjects = false;
                boolean bsubject = false;
                boolean bsubjectname = false;
                boolean bmark = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {


                    if (qName.equalsIgnoreCase("university")) {buniversity = true; }
                    if (qName.equalsIgnoreCase("universityName")) { buniversityname = true;}

                    if (qName.equalsIgnoreCase("faculty")) {bfaculty = true;}
                    if (qName.equalsIgnoreCase("facultyName")) { bfacultyname = true; }

                    if (qName.equalsIgnoreCase("departments")) {bdepartments = true; }
                    if (qName.equalsIgnoreCase("department")) { bdepartment = true; }
                    if (qName.equalsIgnoreCase("departmentName")) { bdepartamentname = true; }

                    if (qName.equalsIgnoreCase("groups")) { bgroups = true;}
                    if (qName.equalsIgnoreCase("group")) { bgroup = true;}
                    if (qName.equalsIgnoreCase("groupName")) { bgroupname = true;}

                    if (qName.equalsIgnoreCase("sudents")) { bsudents = true;}
                    if (qName.equalsIgnoreCase("student")) { bstudent = true;}
                    if (qName.equalsIgnoreCase("firstname")) { bfirstname = true;}
                    if (qName.equalsIgnoreCase("surname")) { bsurname = true;}

                    if (qName.equalsIgnoreCase("subjects")) { bsubjects = true;}
                    if (qName.equalsIgnoreCase("subject")) { bsubject = true;}
                    if (qName.equalsIgnoreCase("subjectname")) { bsubjectname = true;}
                    if (qName.equalsIgnoreCase("mark")) { bmark = true;}

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (buniversityname) {
                        System.out.println("University name: " + new String(ch, start, length));
                        buniversityname = false;
                    }

                    if (bfacultyname) {
                        System.out.println("Faculty name: " + new String(ch, start, length));
                        bfacultyname = false;
                    }

                    if (bdepartamentname) {
                        System.out.println("Department name: " + new String(ch, start, length));
                        bdepartamentname = false;
                    }

                    if (bgroupname) {
                        System.out.println("Group name: " + new String(ch, start, length));
                        bgroupname = false;
                    }

                    if (bstudent) {
                        System.out.println("Student: ");
                        bstudent = false;
                    }

                    if (bsurname) {
                        System.out.println("Surname: " + new String(ch, start, length));
                        bsurname = false;
                    }

                    if (bfirstname) {
                        System.out.println("Firstname: " + new String(ch, start, length));
                        bfirstname = false;
                    }

                    if (bsubjects) {
                        System.out.println("Subjects ");
                        bsubjects = false;
                    }

                    if (bsubjectname) {
                        System.out.println("Subject name: " + new String(ch, start, length));
                        bsubjectname = false;
                    }

                    if (bmark) {
                        System.out.println("Subject's mark: " + new String(ch, start, length));
                        bmark = false;
                    }

                }

            };

            saxParser.parse("university.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

