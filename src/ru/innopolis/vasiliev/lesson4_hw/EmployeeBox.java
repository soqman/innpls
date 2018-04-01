package ru.innopolis.vasiliev.lesson4_hw;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class EmployeeBox implements IEmployeeBox, Externalizable {

    static final long SerialVersionUID = 123123123L;

    private HashSet<Employee> employees;

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public EmployeeBox(ArrayList<Employee> employees) {
        try {
            this.employees.addAll(employees);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public EmployeeBox() {
        this.employees = new HashSet<>();
    }

    @Override
    public boolean save(Employee employee) {
        if (employee == null) {
            return false;
        }
        return employees.add(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employees.remove(employee);
    }

    @Override
    public Employee getByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getByJob(Job job) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getJob() == job) {
                arrayList.add(employee);
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            employees.add(employee);
            return true;
        } else {
            employees.add(employee);
            return false;
        }
    }

    @Override
    public boolean changeAllWork(Job target, Job src) {
        for (Employee employee : employees) {
            if (employee.getJob() == target) {
                employee.setJob(src);
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBox that = (EmployeeBox) o;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(employees);
    }

    @Override
    public String toString() {
        return "EmployeesBox: size " + employees.size();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(employees);
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        out.writeInt(sum);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        employees = (HashSet<Employee>) in.readObject();
        System.out.println("Saved salary sum is:" + in.readInt());

    }
}
