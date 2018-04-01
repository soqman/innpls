package ru.innopolis.vasiliev.lesson4_hw;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private final String name;
    private int age;
    private float salary;
    private Job job;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee(String name, int age, float salary, Job job) {
        if (name.equals("") || name == null) {
            throw new NullPointerException();
        }
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public Employee(String name) {
        if (name.equals("") || name == null) {
            throw new NullPointerException();
        }
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.age = 0;
        this.salary = 0;
        this.job = Job.NONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employee: name " + getName() + ", age " + getAge() + ", Job " + getJob() + ", salary " + getSalary();
    }
}
