package ru.innopolis.vasiliev.lesson4_hw;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Employee employee =new Employee("Pavel",25,25000,Job.BOSS);
        Employee employee2= new Employee("ROMAN");
        Employee employee3= new Employee("Dmitriy");

        EmployeeBox employeeBox= new EmployeeBox();
        EmployeeBox employeeBox2= new EmployeeBox();

        employeeBox.save(employee);
        employeeBox.save(employee2);
        employeeBox.save(employee3);

        //System.out.println("Equals EBox - "+employeeBox.equals(LoadEmployeeBox(Paths.get("1"))));
        //System.out.println(employee.hashCode());
        //System.out.println(LoadEmployeeBox(Paths.get("1")).employees.get(0).hashCode());

        //System.out.println(employeeBox.getByName("Pavel"));
        //System.out.println(employeeBox.employees.get(0));
        //System.out.println(employeeBox.getByJob(Job.NONE));

        System.out.println(SaveEmployeeBox(employeeBox,Paths.get("1")));
    }

    static boolean SaveEmployeeBox(EmployeeBox employeeBox, Path path){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(employeeBox);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
        return false;
    }

    static EmployeeBox LoadEmployeeBox(Path path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))){
            return (EmployeeBox)ois.readObject();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException o){
            o.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
