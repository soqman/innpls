package ru.innopolis.vasiliev.lesson14_hw.pojo;

public class Student extends User{

    public Student(int user_id,String login, int passwordHash) {
        super(user_id,login, passwordHash, UserType.Student);
    }
}
