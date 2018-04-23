package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.dao;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManager;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.User;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO{
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    @Override
    public User getUserById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM users where id=?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("passwordHash"), UserType.valueOf(resultSet.getString("userType")));
        }
        connection.close();
        return user;
    }

    @Override
    public User getUserByName(String name)throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM users where name=?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("passwordHash"), UserType.valueOf(resultSet.getString("userType")));
        }
        connection.close();
        return user;
    }

    @Override
    public boolean addUser(User user)throws SQLException  {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("ADD *FROM users");
        statement.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
