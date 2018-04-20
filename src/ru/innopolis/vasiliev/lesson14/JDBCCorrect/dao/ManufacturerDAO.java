package ru.innopolis.vasiliev.lesson14.JDBCCorrect.dao;

import ru.innopolis.vasiliev.lesson14.JDBCCorrect.pojo.Manufacturer;

import java.sql.SQLException;

public interface ManufacturerDAO {
    public boolean addManunfacturer(Manufacturer manufacturer);
    public Manufacturer getManufacturerById(int id) throws SQLException;
    public boolean updateManufacturer(Manufacturer manufacturer);
    public boolean deleteManufacturerById(int id);
}
