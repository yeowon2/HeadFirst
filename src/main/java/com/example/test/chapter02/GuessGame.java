package com.example.test.chapter02;

public class GuessGame {
    // Player 객체 3개를 저장하기 위한 인스턴스 변수 3개 존재
    Player p1;
    Player p2;
    Player p3;

    public void startGame() {
        // Player 객체 3개를 생성하고 각각을 Player 인스턴스 변수 3개에 대입
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        // Player 객체 3개가 추측한 숫자를 저장하기 위해 변수 3개를 선언
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        // 세 선수가 추측한 숫자가 맞는지 여부를 저장하기 위해 변수 3개 선언
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        // 선수들이 맞힐 숫자를 만듦
        int targetNumber = (int) (Math.random() * 10);
        System.out.println("0 이상 9 이하의 숫자를 맞혀 보세요.");

        while (true) {
            System.out.println("=== 맞혀야 할 숫자는 " + targetNumber + "입니다 ===");

            // 선수별로 guess() 메서드를 호출
            p1.guess();
            p2.guess();
            p3.guess();

            // 각 객체의 인스턴스 변수에 접근해서 각 선수가 추측한 숫자를 알아냄
            guessp1 = p1.number;
            System.out.println("1번 선수가 추측한 숫자 : " + guessp1);
            guessp2 = p2.number;
            System.out.println("2번 선수가 추측한 숫자 : " + guessp2);
            guessp3 = p3.number;
            System.out.println("3번 선수가 추측한 숫자 : " + guessp3);

            // 각 선수가 추측한 숫자 중 정답이 있는지를 확인
            // 맞힌 선수가 있다면 그 선수에 해당하는 변수를 참으로 설정
            if (guessp1 == targetNumber) {
                p1isRight = true;
            }
            if (guessp2 == targetNumber) {
                p2isRight = true;
            }
            if (guessp3 == targetNumber) {
                p3isRight = true;
            }

            // 선수 중 맞힌 선수가 있다면 break문으로 반복문 탈출
            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("맞힌 선수가 있습니다.");
                System.out.println("1번 선수 : " + p1isRight);
                System.out.println("2번 선수 : " + p2isRight);
                System.out.println("3번 선수 : " + p3isRight);
                System.out.println("게임 끝.");
                break;
            } else {
                // 아무도 못 맞힌 경우 다시 시작
                System.out.println("다시 시도해야 합니다.");
            }
        }
    }
}
