package ru.innopolis.vasiliev.lesson14.JDBCCorrect.pojo;

public class Manufacturer {
    private int id;
    private String name;
    private String country;
    private int warranty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public Manufacturer(int id, String name, String country, int warranty) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.warranty = warranty;
    }
}
