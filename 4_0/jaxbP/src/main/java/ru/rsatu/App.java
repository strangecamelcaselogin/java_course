package ru.rsatu;

import ru.rsatu.University;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class App {

    public static void main (String[] args)  {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);

            //получить из xml объект
            Unmarshaller um = jaxbContext.createUnmarshaller();
            University unif = (University) um.unmarshal(new FileReader("./university.xml"));
            Faculty faculty = unif.getFaculty();
            unif.setFaculty(faculty);
            Departments departments = faculty.getDepartments();
            List<Department> departmentList = departments.getDepartment();

            //кусок бесполезного кода - на всякий случай
            for (Department d: departmentList) {
                Groups groups = d.getGroups();
                List<Group> groupList = groups.getGroup();
                for (Group g: groupList){
                    if (g.getGroupName().equals("ПИМ-17")){
                        g.setGroupName("ПИМ-2017");
                    }
                    Students students = g.students;
                    List<Student> studentList = students.getStudent();
                    for (Student s: studentList){
                        Subjects subjects = s.getSubjects();
                        List<Subject> subjectList = subjects.getSubject();
                        for (Subject sub: subjectList){
                            String name = sub.getSubjectName();
                            String mark = sub.getMark();
                        }
                    }
                }
            }

            unif.setUniversityName("МГУ");

            File file = new File("./file.xml");
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(unif, file);
            jaxbMarshaller.marshal(unif, System.out);

            /*for (Student s : studentsList) {
                System.out.println("Student : " + s);
            }*/

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

}
