package ru.innopolis.vasiliev.lesson14_hw.pojo;

public class Administrator extends User {
    public Administrator(int user_id,String login, int passwordHash) {
        super(user_id,login, passwordHash, UserType.Administrator);
    }
}
