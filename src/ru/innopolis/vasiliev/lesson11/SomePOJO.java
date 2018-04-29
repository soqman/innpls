package ru.innopolis.vasiliev.lesson11;

import java.util.Random;

public class SomePOJO {
    final Random  random = new Random();
    private Integer a;
    private String b;
    private Object c;

    public SomePOJO() {
        a=1;
        b="sds";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
