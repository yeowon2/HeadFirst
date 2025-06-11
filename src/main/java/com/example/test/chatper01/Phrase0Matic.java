package com.example.test.chatper01;

public class Phrase0Matic {
    public static void main(String[] args) {

        // 1. 세 종류의 단어 목록을 생성
        String[] wordListOne = {
                "agnostic", "opinionated", "voice activated", "haptically driven", "extensible",
                "reactive", "agent based", "functional", "AI enabled", "strongly typed"
        };

        String[] wordListTwo = {
                "loosely coupled", "six sigma", "asynchronous", "event driven", "pub-sub", "IoT",
                "cloud native", "service oriented", "containerized", "serverless", "microserviceds", "distributed ledger"
        };

        String[] wordListThree = {
                "framework", "library", "DSL", "REST API", "repository", "pipeline", "service mesh",
                "architecture", "perspective", "design", "orientation"
        };

        // 2. 각 단어 목록에 단어가 몇 개씩 들어있는지 확인
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        // 3. 난수 세 개를 발생시킴
        java.util.Random rand = new java.util.Random();
        int rand1 = rand.nextInt(oneLength);
        int rand2 = rand.nextInt(twoLength);
        int rand3 = rand.nextInt(threeLength);

        // 4. 구문 생성
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        // 5. 구문 출력
        System.out.println("What we need is a " + phrase);
    }
}
