package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.dao;

import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.*;

import java.sql.SQLException;

public interface IUserDAO {
    public User getUserById(int id)throws SQLException;
    public User getUserByName(String name)throws SQLException;
    public boolean addUser(User user)throws SQLException;
    public boolean updateUser(User user)throws SQLException;
    public boolean deleteUser(User user)throws SQLException;
}
