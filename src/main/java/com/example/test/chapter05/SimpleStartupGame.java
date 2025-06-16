package com.example.test.chapter05;

import java.util.ArrayList;

public class SimpleStartupGame {
    public static void main(String[] args) {
        // 사용자가 추측한 횟수를 추적하기 위한 변수 생성
        int numOfGuesses = 0;
        // 사용자로부터 입력을 받기 위한 메서드가 들어 있는 특별한 클래스가 있다고 가정
        GameHelper helper = new GameHelper();

        Startup theStartup = new Startup();

        // 0~4 사이의 난수를 리턴받기 위해 5를 곱해줌 (
        int randNum = (int) (Math.random() * 5);
        ArrayList<String> locations = new ArrayList<>();
        theStartup.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive) {
            int guess = helper.getUserInput("enter a number ==: ");
            // 스타트업 객체를 통해 추측한 값이 맞는지 확인
            String result = theStartup.checkYourself(guess);
            numOfGuesses++;

            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("you took " + numOfGuesses + " guesses");
            }
        }
    }
}
