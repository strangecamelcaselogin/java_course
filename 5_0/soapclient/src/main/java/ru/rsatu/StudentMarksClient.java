package ru.rsatu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import com.sun.xml.internal.ws.fault.ServerSOAPFaultException;
import ru.rsatu.ws.StudentMarks;

public class StudentMarksClient {

    public static void main(String[] args) throws Exception {

        URL wsdlURL = StudentMarksClient.class.getClassLoader().getResource("studentMarks.wsdl");

        //BindingProvider

        QName qname = new QName("http://rsatu.ru/", "StudentMarksService");

        Service service = Service.create(wsdlURL, qname);

        StudentMarks studentMarksService = service.getPort(StudentMarks.class);

        BindingProvider bp = (BindingProvider) studentMarksService;

        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://laptop:8080/StudentMarksService/StudentMarks");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Введите шифр группы:");
            String groupName = br.readLine();

            System.out.println("Введите фамилию студента:");
            String lastName = br.readLine();

            System.out.println("Введите Имя студента:");
            String firstName = br.readLine();

            try {
                Subjects response = studentMarksService.getMarksByGroupAndName(groupName, firstName, lastName);
                List<Subject> subjectList = response.getSubjects();

                if (subjectList.size() == 0) {
                    System.out.println("Такого студента не существует");
                }
                else {
                    for (Subject s: subjectList) {
                        System.out.println(s.getSubjectName() + ": " + s.getMark());
                    }
                }
            } catch (ServerSOAPFaultException ignored) {
                System.out.println("Не получилось!");
            }

            System.out.println("Продолжить? y/n");

            if (br.readLine().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

}