package com.example.test.chapter05;

public class SimpleStartup {
    private int[] locationCells;
    private int numOfHits = 0;

    public String checkYourself(int guess) {
        // 리턴할 값을 저장할 변수를 만듦 (기본적으로 못 맞추는 상황을 가정하고 시작)
        String result = "miss";

        for (int cell : locationCells) {
            // 사용자가 추측한 값을 배열에 있는 원소(셀)와 비교
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "kill";
        }

        System.out.println(result);
        return result;
    }

    public void setLocationCells(int[] locations) {
        locationCells = locations;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    public void setNumOfHits(int numOfHits) {
        this.numOfHits = numOfHits;
    }
}
