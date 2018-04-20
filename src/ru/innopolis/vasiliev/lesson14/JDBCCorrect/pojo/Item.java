package ru.innopolis.vasiliev.lesson14.JDBCCorrect.pojo;

public class Item {
    private int id;
    private String name;
    private double price;
    private String description;
    private String image;
    private int category_id;
    private Category category;

    public Item(int id, String name, double price, String description, String image, Category category, Manufacturer manufacturerImpl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.manufacturerImpl = manufacturerImpl;
    }

    public Item(int id, String name, double price, String description, String image, int category_id, Category category, int manufacturer, Manufacturer manufacturerImpl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category_id = category_id;
        this.category = category;
        this.manufacturer = manufacturer;
        this.manufacturerImpl = manufacturerImpl;
    }

    private int manufacturer;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturerImpl() {
        return manufacturerImpl;
    }

    public void setManufacturerImpl(Manufacturer manufacturerImpl) {
        this.manufacturerImpl = manufacturerImpl;
    }

    private Manufacturer manufacturerImpl;
}
