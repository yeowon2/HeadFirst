package com.example.test.chapter05;

import java.util.ArrayList;

public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        // Startup 클래스의 객체를 만듦
        Startup dot = new Startup();

        // 스타트업 위치를 나타내기 위한 int 배열을 만듦 (일곱 개의 연속된 정수 가운데 세 개)
        ArrayList<String> locations = new ArrayList<>();
        dot.setLocationCells(locations);

        // 사용자가 추측한 위치 역할을 할 가짜 값을 만듦
        int userGuess = 2;
        // 스타트업 객체에 대해 checkYourself() 메서드를 호출하고 그 메서드에 가짜 값을 전달
        String result = dot.checkYourself(userGuess);

        String testResult = "failed";
        if (result.equals("hit")) {
            // 가짜 값(2)이 맞으면 ("hit"가 리턴되면) 제대로 작동한다는 것을 알 수 있음)
            testResult = "passed";
        }

        System.out.println(testResult);
    }
}
