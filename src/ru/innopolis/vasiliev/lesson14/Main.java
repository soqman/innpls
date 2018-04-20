package ru.innopolis.vasiliev.lesson14;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "vvn", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM manufacturer");
        while (resultSet.next()){
            System.out.print(resultSet.getString("name")+"; ");
            System.out.print(resultSet.getString("country")+"; ");
            System.out.println(resultSet.getInt("warranty")+"; ");
        }
        connection.close();

    }
}
