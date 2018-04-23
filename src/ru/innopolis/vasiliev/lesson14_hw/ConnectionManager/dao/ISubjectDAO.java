package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.dao;

import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.Subject;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.User;

import java.util.HashSet;

public interface ISubjectDAO {
    public Subject getSubjectbyId(int id);
    public Subject getSubjectByName(String name);
    public HashSet<Subject> getSubjectListByUser(User user);
    public boolean addSubject(Subject subject);
    public boolean updateSubject(Subject subject);
    public boolean deleteSubject(Subject subject);



}
