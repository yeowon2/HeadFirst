package com.example.test.chapter06;

import com.example.test.chapter06.GameHelper;
import com.example.test.chapter06.Startup;

import java.util.ArrayList;

public class StartupBust {
    // 사용할 변수 선언하고 초기화
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // 우선 스타트업 객체 몇 개를 만들고 위치 지정
        // startup 객체 세 개를 만들고 각각 이름을 부여한 후에 ArrayList에 저장
        Startup one = new Startup();
        one.setName("one");
        Startup two = new Startup();
        two.setName("two");
        Startup three = new Startup();
        three.setName("three");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        // 사용자에게 간단한 게임 방법 설명
        System.out.println("Your goal is to sink three Startups.");
        System.out.println("one, two, three");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        for (Startup startup : startups) { // 목록에 있는 각 startup에 대해 반복
            // startup의 위치를 지정하기 위한 보조 메서드 호출
            ArrayList<String> newLocation = helper.placeStartup(3);
            // 이 startup 객체의 세터메서드를 호출해 방금 보조 메서드에서 받아온 위치 지정
            startup.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!startups.isEmpty()) {   // startup 목록이 비어 있지 않으면
            // 사용자의 입력 받기
            String userGuess = helper.getUserInput("Enter a guess == : ");
            // checkUserGuess 메서드 호출
            checkUserGuess(userGuess);
        }
        // finishGame 메서드  호출
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        // 사용자가 추측한 횟수 증가
        numOfGuesses++;
        // 따로 바꾸지 않으면 "miss"라고 가정
        String result = "miss";

        // 목록에 들어있는 모든 startup 객체에 대해 반복함
        for (Startup startupToTest : startups) {
            // startup 객체에 사용자가 입력한 위치가 맞는지 또는 그 객체가 침몰했는지 물어봄
            result = startupToTest.checkYourself(userGuess);

            if (result.equals("hit")) {
                // 반복문에 일찍 빠져나옴(나머지는 더 이상 확인하지 않아도 됨)
                break;
            }
            if (result.equals("kill")) {
                // 침몰했으므로 startup목록에서 빼고 반복문을 빠져 나감
                startups.remove(startupToTest);
                break;
            }
        }

        // 사용자에게 결과 출력
        System.out.println(result);
    }

    private void finishGame() {
        // 게임 결과를 알려주는 메세지 출력
        System.out.println("All Startups are dead! Your stock si now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses!");
            System.out.println("You got out before your options sank");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses!");
            System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        // 게임 객체를 만듦
        StartupBust game = new StartupBust();
        // 게임 객체에 게임을 설정하는 명령을 내림
        game.setUpGame();
        // 게임 객체에 주 게임 진행 반복문을 돌리라는 명령을 내림
        // (사용자에게 계속해서 위치를 물어보고 그 추측을 확인함)
        game.startPlaying();
    }
}
