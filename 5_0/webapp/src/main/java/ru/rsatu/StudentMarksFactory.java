package ru.rsatu;

import javax.enterprise.inject.Produces;

public class StudentMarksFactory {

//    @Produces
    public StudentMarksService getStudentMark() {
        return new StudentMarksServiceImpl();
    }
}
