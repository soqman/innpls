package ru.innopolis.vasiliev.lesson14_hw.dao;

import org.apache.log4j.Logger;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManager;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Student;
import ru.innopolis.vasiliev.lesson14_hw.pojo.User;
import ru.innopolis.vasiliev.lesson14_hw.pojo.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class StudentDAO implements IStudentDAO {
    final static Logger logger=Logger.getLogger(SubjectDAO.class);
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private UserDAO userDAO=new UserDAO();
    @Override
    public HashSet<Student> getStudentsListBySubjectId(int subject_id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT user_id FROM grades where subject_id=?");
        statement.setInt(1, subject_id);
        ResultSet resultSet = statement.executeQuery();
        HashSet<Student> students=new HashSet<>();
        while (resultSet.next()) {
            User user = userDAO.getUserById(resultSet.getInt("user_id"));
            students.add(new Student(user.getUser_id(),user.getLogin(),user.getPasswordHash()));
        }
        return students;
    }

    @Override
    public HashSet<Student> getAllStudents() throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT user_id FROM users where user_type=?");
        statement.setString(1, UserType.Student.toString());
        ResultSet resultSet = statement.executeQuery();
        HashSet<Student> students=new HashSet<>();
        while (resultSet.next()) {
            User user = userDAO.getUserById(resultSet.getInt("user_id"));
            students.add(new Student(user.getUser_id(),user.getLogin(),user.getPasswordHash()));
        }
        return students;
    }
}
