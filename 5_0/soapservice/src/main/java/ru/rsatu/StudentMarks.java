package ru.rsatu;

import org.xml.sax.SAXException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class StudentMarks {

    private StudentMarksService studentMarksService;

    public StudentMarks() {
        try {
            this.studentMarksService = new StudentMarksService();
        }
        catch (IOException | SAXException | ParserConfigurationException e) {
            throw new RuntimeException("Can not initialize StudentMarksService");
        }
    }

    @WebMethod
    public Subjects getMarksByGroupAndName(@WebParam String group,
                                           @WebParam String firstName,
                                           @WebParam String lastName) {

        Subjects result = studentMarksService.getMarks(group, firstName, lastName);

        System.out.println("Student: '" + firstName + "'\n Group: " + group + "\n\n");

        return result != null ? result : new Subjects();

    }
}