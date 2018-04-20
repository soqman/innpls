package ru.innopolis.vasiliev.lesson14;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "vvn", "password");
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM manufacturer where country=? and warranty <?");
        statement.setString(1,"Finland");
        statement.setInt(2,18);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            System.out.print(resultSet.getString("name")+"; ");
            System.out.print(resultSet.getString("country")+"; ");
            System.out.println(resultSet.getInt("warranty")+"; ");
        }
        connection.close();
    }
}
