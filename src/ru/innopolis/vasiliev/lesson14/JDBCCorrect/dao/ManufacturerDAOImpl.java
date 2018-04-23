package ru.innopolis.vasiliev.lesson14.JDBCCorrect.dao;

import ru.innopolis.vasiliev.lesson14.JDBCCorrect.ConnectionManager.ConnectionManager;
import ru.innopolis.vasiliev.lesson14.JDBCCorrect.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.vasiliev.lesson14.JDBCCorrect.pojo.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerDAOImpl implements ManufacturerDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    @Override
    public boolean addManufacturer(Manufacturer manufacturer) {
        return false;
    }

    @Override
    public Manufacturer getManufacturerById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM manufacturer where id=?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Manufacturer manufacturer = null;
        while (resultSet.next()) {
            manufacturer = new Manufacturer(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("country"), resultSet.getInt("warranty"));
        }
        connection.close();
        return manufacturer;
    }

    @Override
    public boolean updateManufacturer(Manufacturer manufacturer) {
        return false;
    }

    @Override
    public boolean deleteManufacturerById(int id) {
        return false;
    }
}
