package ru.innopolis.vasiliev.lesson6_hw;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args){
        Pupil pupil = new Pupil();
        pupil.setAge(10);
        pupil.setName("MISHA");
        System.out.println(pupil.toString());
        Class<Pupil> clazz = (Class<Pupil>) pupil.getClass();
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
