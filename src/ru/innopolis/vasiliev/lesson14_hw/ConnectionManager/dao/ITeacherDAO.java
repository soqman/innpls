package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.dao;

import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Subject;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Teacher;

import java.util.HashSet;

public interface ITeacherDAO {
    public Teacher getTeacherBySubject(Subject subject);
    public HashSet<Teacher> getAllTeachers();
}
