package ru.innopolis.vasiliev.lesson14_hw.dao;

import ru.innopolis.vasiliev.lesson14_hw.pojo.Student;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Subject;

import java.sql.SQLException;
import java.util.HashSet;

public interface IStudentDAO {
    public HashSet<Student> getStudentsListBySubjectId(int subject_id)throws SQLException;
    public HashSet<Student> getAllStudents()throws SQLException;
}
