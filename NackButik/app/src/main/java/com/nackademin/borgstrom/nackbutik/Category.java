package com.nackademin.borgstrom.nackbutik;

/**
 * Created by borgs_000 on 2016-03-15.
 */
public class Category {

    int id;
    String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
