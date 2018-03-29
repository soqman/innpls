package ru.innopolis.vasiliev.lesson4_hw;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Employee employee1 =new Employee("Pavel",40,100000,Job.CEO);
        Employee employee2= new Employee("ROMAN",27,40000,Job.MANAGER);
        Employee employee3= new Employee("Dmitriy",22,40000,Job.MANAGER);
        Employee employee4= new Employee("Viktor");
        Employee employee5 =new Employee("Natalia",25,30000,Job.CLEANER);

        EmployeeBox employeeBox= new EmployeeBox();

        employeeBox.save(employee1);
        employeeBox.save(employee2);
        employeeBox.save(employee3);

        //проверка методов EmployeeBox
        System.out.println(employeeBox);

        System.out.println(employeeBox.getByName("Pavel"));
        employeeBox.saveOrUpdate(new Employee("Pavel",50,10000,Job.CLEANER));
        System.out.println(employeeBox.getByName("Pavel"));
        employeeBox.changeAllWork(Job.MANAGER,Job.CLEANER);
        System.out.println((employeeBox.getByJob(Job.CLEANER)).toString());

        System.out.println(employeeBox.delete(new Employee("JESUS")));
        System.out.println("Equals EBox - "+employeeBox.equals(LoadEmployeeBox(Paths.get("ExternalizableOutput"))));

        //Externalizable
        SaveEmployeeBox(employeeBox,Paths.get("ExternalizableOutput"));
        EmployeeBox employeeBoxLoaded = LoadEmployeeBox(Paths.get("ExternalizableOutput"));


        //проверка Externalizable
        /*for(Employee loadedEmployee:employeeBoxLoaded.employees){
            System.out.println(loadedEmployee.toString());
        }*/

        //Custom serialization
        SaveEmployeeBoxCustom(employeeBox,Paths.get("CustomOutput"));
        EmployeeBox employeeBoxLoadedBuffered = LoadEmployeeBoxCustom(Paths.get("CustomOutput"));

        //проверка Custom serialization
        /*for(Employee loadedEmployee:employeeBoxLoadedBuffered.employees){
            System.out.println(loadedEmployee.toString());
        }*/
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

    static boolean SaveEmployeeBoxCustom(EmployeeBox employeeBox, Path path){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()))) {
            for(Employee employee:employeeBox.getEmployees()){
                bw.write("New employee right below"+"\n");
                bw.write((employee.getName()+"\n"));
                bw.write((employee.getAge()+"\n"));
                bw.write((employee.getSalary()+"\n"));
                bw.write((employee.getJob().name()+"\n"));
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException o) {
            o.printStackTrace();
        }
        return false;
    }

    static EmployeeBox LoadEmployeeBoxCustom(Path path){
        try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))){
            EmployeeBox employeeBox=new EmployeeBox();
            while(br.readLine()!=null){
                employeeBox.save(new Employee(br.readLine(),Integer.parseInt(br.readLine()),Float.parseFloat(br.readLine()),Enum.valueOf(Job.class,br.readLine())));
            }
            return employeeBox;
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException o){
            o.printStackTrace();
        }
        return null;
    }
}
