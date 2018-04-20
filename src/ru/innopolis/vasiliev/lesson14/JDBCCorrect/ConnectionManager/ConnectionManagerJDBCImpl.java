package ru.innopolis.vasiliev.lesson14.JDBCCorrect.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBCImpl implements ConnectionManager{
    private static ConnectionManager connectionManager=ConnectionManagerJDBCImpl.getInstance();

    public static ConnectionManager getInstance(){
        if(connectionManager==null){
            connectionManager=new ConnectionManagerJDBCImpl();
        }
        return connectionManager;
    }

    private ConnectionManagerJDBCImpl(){

    }

    @Override
    public Connection getConnection() {
        Connection connection=null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "vvn", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
