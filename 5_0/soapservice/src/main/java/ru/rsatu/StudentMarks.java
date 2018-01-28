package ru.rsatu;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class StudentMarks {

    @Inject
    private StudentMarksService studentMarksService;

    public StudentMarks() {}

    @WebMethod
    public Subjects getMarksByGroupAndName(@WebParam String group,
                                           @WebParam String firstName,
                                           @WebParam String lastName) {
        if (studentMarksService == null) {
            System.out.println("Инъекция не сработала");
        }
        else {
            Subjects result = studentMarksService.getMarks("РГАТУ", "ФРЭИ", group, firstName, lastName);

            return result;
        }

        return new Subjects();
    }
}