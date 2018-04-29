package ru.innopolis.vasiliev.lesson14_hw.pojo;

public class Teacher extends User{
    public Teacher(int user_id,String login, int passwordHash) {
        super(user_id,login, passwordHash, UserType.Teacher);
    }
}
