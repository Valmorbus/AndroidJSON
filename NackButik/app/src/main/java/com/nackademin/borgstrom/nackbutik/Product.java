package com.nackademin.borgstrom.nackbutik;

/**
 * Created by borgs_000 on 2016-03-15.
 */
public class Product {
    int id;
    String name;
    String description;
    double price;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
