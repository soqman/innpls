package ru.innopolis.vasiliev.lesson6;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args){
        Student student = new Student();
        student.setAge(10);
        student.setName("MISHA");
        System.out.println(student.toString());
        Class<Student> clazz = (Class<Student>) student.getClass();
        try {
            Object newPupul = clazz.newInstance();
            try {
                Field ageAlt = clazz.getDeclaredField("age");
                ageAlt.setAccessible(true);
                ageAlt.set(newPupul,20);
                Field nameAlt = clazz.getField("name");
                nameAlt.set(newPupul,"Michael");
                Field aliveAlt = clazz.getDeclaredField("age");
                aliveAlt.setAccessible(true);
                aliveAlt.set(newPupul,true);
                System.out.println(newPupul.toString());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
