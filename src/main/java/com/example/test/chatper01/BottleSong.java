package com.example.test.chatper01;

public class BottleSong {
    public static void main(String[] args) {
        int bottlesNum = 10;
        String word = "bottles";    // 복수형

        while (bottlesNum > 0) {
            if (bottlesNum == 1) {
                word = "bottle";    // 단수형(한 병인 경우)
            }

            System.out.println(bottlesNum + " green " + word + ", hanging on the wall");
            System.out.println(bottlesNum + " green " + word + ", hanging on the wall");
            System.out.println("And if one green bottle shold accidentally fall,");
            bottlesNum--;

            if (bottlesNum > 0) {
                System.out.println("There'll be " + bottlesNum + " green " + word + ", hanging on the wall");
            } else {
                System.out.println("There'll be no green bottles, hanging on the wall");
            }   // else 끝
        }   // while 반복문 끝
    }   // main 메서드 끝
}
