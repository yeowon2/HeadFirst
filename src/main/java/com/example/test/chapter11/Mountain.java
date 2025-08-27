package com.example.test.chapter11;

public class Mountain {
    private String name;
    private int height;

    public Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + height;
    }
}
