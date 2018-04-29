package ru.innopolis.vasiliev.lesson14_hw.dao;

import ru.innopolis.vasiliev.lesson14_hw.pojo.Grade;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Student;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Subject;

import java.sql.SQLException;

public interface IGradeDAO {
    public Grade getGrade(int student_id, int subject_id)throws SQLException;
    public boolean setGrade(int student_id, int subject_id, Grade grade)throws SQLException;
}
