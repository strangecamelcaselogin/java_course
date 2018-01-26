package ru.rsatu;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class StudentMarks {

    private StudentMarksService studentMarksService;

    public StudentMarks() {
        this.studentMarksService = new StudentMarksService();
    }

    @WebMethod
    public Subjects getMarksByGroupAndName(@WebParam String group,
                                           @WebParam String firstName,
                                           @WebParam String lastName) {

        Subjects result = studentMarksService.getMarks("РГАТУ", "ФРЭИ", group, firstName, lastName);

        return result != null ? result : new Subjects();

    }
}