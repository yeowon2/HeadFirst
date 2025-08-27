package com.example.test.chapter11;

public class Book implements Comparable<Book>{
    @Override
    public int compareTo(Book o) {
        return o.toString().compareTo(this.toString());
    }

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
