package ru.innopolis.vasiliev.lesson14_hw.dao;
import org.apache.log4j.Logger;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManager;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.vasiliev.lesson14_hw.pojo.User;
import ru.innopolis.vasiliev.lesson14_hw.pojo.UserType;

import java.sql.*;

public class UserDAO implements IUserDAO{
    final static Logger logger=Logger.getLogger(UserDAO.class);
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    @Override
    public User getUserById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM users where user_id=?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getInt("user_id"), resultSet.getString("login"), resultSet.getInt("password_hash"), UserType.valueOf(resultSet.getString("user_type")));
        }
        connection.close();
        return user;
    }

    @Override
    public User getUserByLogin(String login)throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM users where login=?");
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getInt("user_id"), resultSet.getString("login"), resultSet.getInt("password_hash"), UserType.valueOf(resultSet.getString("user_type")));
        }
        connection.close();
        return user;
    }

    @Override
    public boolean addUser(User user)throws SQLException  {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO users (user_id, user_type, password_hash, login) VALUES (DEFAULT, ?, ?, ?)");
        statement.setString(1, user.getUserType().toString());
        statement.setInt(2,user.getPasswordHash());
        statement.setString(3,user.getLogin());
        int i = statement.executeUpdate();
        connection.close();
        return i>0?true:false;
    }

    @Override
    public boolean updateUser(User user)throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE users SET user_type = ?,password_hash=?,login=? WHERE user_id = ?");
        statement.setString(1, user.getUserType().toString());
        statement.setInt(2,user.getPasswordHash());
        statement.setString(3,user.getLogin());
        statement.setInt(4,user.getUser_id());
        int i =statement.executeUpdate();
        connection.close();
        return i>0?true:false;
    }

    @Override
    public boolean deleteUserById(int id)throws SQLException {
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        int i =statement.executeUpdate("DELETE FROM users WHERE user_id = "+id);
        connection.close();
        return i>0?true:false;
    }
}
