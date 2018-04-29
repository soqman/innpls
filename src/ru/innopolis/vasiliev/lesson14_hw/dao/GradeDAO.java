package ru.innopolis.vasiliev.lesson14_hw.dao;

import org.apache.log4j.Logger;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManager;
import ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Grade;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Student;
import ru.innopolis.vasiliev.lesson14_hw.pojo.Subject;

import java.sql.*;

public class GradeDAO implements IGradeDAO {
    final static Logger logger=Logger.getLogger(SubjectDAO.class);
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    @Override
    public Grade getGrade(int student_id, int subject_id)throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT grade FROM grades where user_id=? AND subject_id=?");
        statement.setInt(1, student_id);
        statement.setInt(2, subject_id);
        ResultSet resultSet = statement.executeQuery();
        Grade grade = null;
        while (resultSet.next()) {
            grade = Grade.valueOf(resultSet.getString("grade"));
        }
        connection.close();
        return grade;
    }

    @Override
    public boolean setGrade(int student_id, int subject_id, Grade grade)throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE grades SET grade = ? WHERE subject_id = ? AND user_id=?");
        statement.setString(1, grade.toString());
        statement.setInt(2,subject_id);
        statement.setInt(3,student_id);
        int i =statement.executeUpdate();
        connection.close();
        return i>0?true:false;
    }
}
