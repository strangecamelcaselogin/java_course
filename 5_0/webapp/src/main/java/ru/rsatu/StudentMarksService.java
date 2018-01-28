package ru.rsatu;

public interface StudentMarksService {
    public Subjects getMarks(String university,
                             String faculty,
                             String groupName,
                             String firstName,
                             String lastName);
}
