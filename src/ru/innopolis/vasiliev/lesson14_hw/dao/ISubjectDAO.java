package ru.innopolis.vasiliev.lesson14_hw.dao;

import ru.innopolis.vasiliev.lesson14_hw.pojo.Subject;
import ru.innopolis.vasiliev.lesson14_hw.pojo.User;

import java.sql.SQLException;
import java.util.HashSet;

public interface ISubjectDAO {
    public Subject getSubjectById(int id)throws SQLException;
    public Subject getSubjectByName(String name)throws SQLException;
    public HashSet<Subject> getSubjectListByUserId(int user_id)throws SQLException;
    public boolean addSubject(Subject subject)throws SQLException;
    public boolean updateSubject(Subject subject)throws SQLException;
    public boolean deleteSubject(int id)throws SQLException;



}
