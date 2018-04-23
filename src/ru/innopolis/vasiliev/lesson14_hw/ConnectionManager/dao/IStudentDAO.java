package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.dao;

import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Student;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Subject;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.User;

import java.util.HashSet;

public interface IStudentDAO {
    public HashSet<Student> getStudentsListBySubject(Subject subject);
    public HashSet<Student> getAllStudents();
}
