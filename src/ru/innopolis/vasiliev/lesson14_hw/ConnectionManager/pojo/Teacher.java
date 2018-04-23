package ru.innopolis.vasiliev.lesson14_hw.ConnectionManager.pojo;

public class Teacher extends User{
    public Teacher(int user_id,String login, String passwordHash, UserType userType) {
        super(user_id,login, passwordHash, userType);
    }
}
