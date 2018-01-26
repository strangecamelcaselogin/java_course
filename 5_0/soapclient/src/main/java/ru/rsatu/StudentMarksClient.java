package ru.rsatu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ru.rsatu.ws.StudentMarks;
import ru.rsatu.ws.Subjects;

public class StudentMarksClient {

    public static void main(String[] args) throws Exception {

        URL wsdlURL = StudentMarksClient.class.getClassLoader().getResource("studentMarks.wsdl");

        QName qname = new QName("http://rsatu.ru/", "StudentMarksService");

        Service service = Service.create(wsdlURL, qname);

        StudentMarks studentMarksService = service.getPort(StudentMarks.class);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите шифр группы:");
        String groupName = br.readLine();

        System.out.println("Введите фамилию студента:");
        String lastName = br.readLine();

        System.out.println("Введите Имя студента:");
        String firstName = br.readLine();

        Subjects response = studentMarksService.getMarksByGroupAndName(groupName, firstName, lastName);

        System.out.println(response);

    }

}