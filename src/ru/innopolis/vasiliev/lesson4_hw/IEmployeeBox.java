package ru.innopolis.vasiliev.lesson4_hw;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeBox {
    boolean save(Employee employee);
    boolean delete(Employee employee);
    Employee getByName(String name);
    List <Employee> getByJob(Job job );
    boolean saveOrUpdate(Employee employee);
    boolean changeAllWork(Job target, Job src);
}
