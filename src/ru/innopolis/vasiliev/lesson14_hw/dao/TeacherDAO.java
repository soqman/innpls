package ru.innopolis.vasiliev.lesson14_hw.dao;

import org.apache.log4j.Logger;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManager;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.vasiliev.lesson14_hw.pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class TeacherDAO implements ITeacherDAO{
    final static Logger logger=Logger.getLogger(SubjectDAO.class);
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private UserDAO userDAO=new UserDAO();
    @Override
    public Teacher getTeacherBySubjectId(int subject_id)throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT teacher_id FROM subjects where subject_id=?");
        statement.setInt(1, subject_id);
        ResultSet resultSet = statement.executeQuery();
        User user=null;
        while (resultSet.next()) {
            user=userDAO.getUserById(resultSet.getInt("teacher_id"));
        }
        return new Teacher(user.getUser_id(),user.getLogin(),user.getPasswordHash());
    }

    @Override
    public HashSet<Teacher> getAllTeachers() throws SQLException{
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT user_id FROM users where user_type=?");
        statement.setString(1, UserType.Teacher.toString());
        ResultSet resultSet = statement.executeQuery();
        HashSet<Teacher> teachers=new HashSet<>();
        while (resultSet.next()) {
            User user = userDAO.getUserById(resultSet.getInt("user_id"));
            teachers.add(new Teacher(user.getUser_id(),user.getLogin(),user.getPasswordHash()));
        }
        return teachers;
    }
}
