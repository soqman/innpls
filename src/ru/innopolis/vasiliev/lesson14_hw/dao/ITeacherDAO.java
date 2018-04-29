package ru.innopolis.vasiliev.lesson14_hw.dao;

import ru.innopolis.vasiliev.lesson14_hw.pojo.Subject;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Teacher;

import java.sql.SQLException;
import java.util.HashSet;

public interface ITeacherDAO {
    public Teacher getTeacherBySubjectId(int subject_id)throws SQLException;;
    public HashSet<Teacher> getAllTeachers()throws SQLException;;
}
