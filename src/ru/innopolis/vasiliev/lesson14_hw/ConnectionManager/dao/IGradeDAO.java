package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.dao;

import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Grade;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Student;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Subject;

public interface IGradeDAO {
    public Grade getGrade(Student student, Subject subject);
    public boolean setGrade(Student student, Subject subject);
}
