package ru.innopolis.vasiliev.lesson14;

import java.sql.*;

public class Main3 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "vvn", "password");
        PreparedStatement statement = connection.prepareStatement("UPDATE manufacturer set warranty=24 where id=?");
        for(String arg:args){
            statement.setInt(1,Integer.parseInt(arg));
            statement.addBatch();
        }
        statement.executeBatch();
        //connection.commit();
        connection.close();
    }
}
