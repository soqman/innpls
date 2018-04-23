package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo;

public class Student extends User{

    public Student(int user_id,String login, String passwordHash, UserType userType) {
        super(user_id,login, passwordHash, userType);
    }
}
