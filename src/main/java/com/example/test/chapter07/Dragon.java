package com.example.test.chapter07;

public class Dragon extends Monster {
    @Override
    public boolean frighten(int degree) {
        System.out.println("breathe fire");
        return true;
    }
}
