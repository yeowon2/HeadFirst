package com.example.test.chapter02;

public class Player {
    // 추측할 숫자를 저장할 변수
    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("추측한 숫자: " + number);
    }
}
