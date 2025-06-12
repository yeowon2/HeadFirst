package com.example.test.chapter02;

public class MovieTestDrive {
    public static void main(String[] args) {
        Movie one = new Movie();
        one.title = "서브스턴스";
        one.genre = "바디 호러";
        one.rating = 100;
        one.playIt();

        Movie two = new Movie();
        two.title = "외계+인";
        two.genre = "SF";
        two.rating = -2;

        Movie three = new Movie();
        three.title = "캐롤";
        three.genre = "로맨스";
        three.rating = 120;
    }
}
