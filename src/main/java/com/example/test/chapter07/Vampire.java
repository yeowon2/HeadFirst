package com.example.test.chapter07;

public class Vampire extends Monster {
    @Override
    public boolean frighten(int f) {
        System.out.println("a bite?");
        return true;
    }
}
