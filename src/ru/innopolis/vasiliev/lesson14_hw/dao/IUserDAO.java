package ru.innopolis.vasiliev.lesson14_hw.dao;

import ru.innopolis.vasiliev.lesson14_hw.pojo.*;

import java.sql.SQLException;

public interface IUserDAO {
    public User getUserById(int id)throws SQLException;
    public User getUserByLogin(String login)throws SQLException;
    public boolean addUser(User user)throws SQLException;
    public boolean updateUser(User user)throws SQLException;
    public boolean deleteUserById(int id)throws SQLException;
}
