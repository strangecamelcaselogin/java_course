package ru.rsatu;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;


public class App {

    public static void main (String[] args)  throws SAXException{

        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            URL xsd = App.class.getClassLoader().getResource("university.xsd");
            URL xml = App.class.getClassLoader().getResource("university.xml");

            Schema schema = schemaFactory.newSchema(xsd);

            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);

            //получить из xml объект
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);
            University university = (University) unmarshaller.unmarshal(xml);
            Faculty faculty = university.getFaculty();
            university.setFaculty(faculty);
            Departments departments = faculty.getDepartments();
            List<Department> departmentList = departments.getDepartments();

            //кусок бесполезного кода - на всякий случай
            for (Department d: departmentList) {
                Groups groups = d.getGroups();
                List<Group> groupList = groups.getGroups();
                for (Group g: groupList){
                    if (g.getGroupName().equals("ПИМ-17")){
                        g.setGroupName("ПИМ-2017");
                    }
                    Students students = g.students;
                    List<Student> studentList = students.getStudents();
                    for (Student s: studentList){
                        Subjects subjects = s.getSubjects();
                        List<Subject> subjectList = subjects.getSubjects();
                        for (Subject sub: subjectList){
                            String name = sub.getSubjectName();
                            String mark = sub.getMark();
                        }
                    }
                }
            }

            university.setUniversityName("МГУ");

            File file = new File("./file.xml");
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(university, file);
            jaxbMarshaller.marshal(university, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

}
