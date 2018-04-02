package ru.innopolis.vasiliev.lesson6_hw;

public class Pupil {
    private int age;
    public String name;
    private boolean alive;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "name "+name+", age "+age+", alive "+alive;

    }
}
