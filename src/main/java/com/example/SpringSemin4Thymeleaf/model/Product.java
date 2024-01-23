package com.example.SpringSemin4Thymeleaf.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private int count_prod;

    public Product() {
    }

    public Product(int id, String name, String description, int count_prod) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.count_prod = count_prod;
    }
    // region getters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount_prod() {
        return count_prod;
    }

    public void setCount_prod(int count_prod) {
        this.count_prod = count_prod;
    }
    // endregion
}
