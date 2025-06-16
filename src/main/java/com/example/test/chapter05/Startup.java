package com.example.test.chapter05;

import java.util.ArrayList;

public class Startup {
    private String setName;
    private ArrayList<String> locationCells;
    private int numOfHits = 0;

    public String checkYourself(int userInput) {
        // 리턴할 값을 저장할 변수를 만듦 (기본적으로 못 맞추는 상황을 가정하고 시작)
        String result = "miss";
        // 사용자가 추측한 위치가 ArrayList에 들어 있는지 확인
        // 들어 있으면 인덱스 번호가 리턴되고, 그렇지 않으면 indexOf()는 -1 리턴
        int index = locationCells.indexOf(userInput);

        // 사용자가 추측한 값을 배열에 있는 원소(셀)와 비교
        // 한 번 맞춘 셀을 배제시키지 않아 같은 원소를 3번 적어도 통과됨 (맞힌 원소는 제거 필요)
        if (index >= 0) {   // index가 0이상이면 사용자가 추측한 위치에 들어있는 것
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }

        }

        System.out.println(result);
        return result;
    }

    public void setLocationCells(ArrayList<String> locations) {
        locationCells = locations;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    public void setNumOfHits(int numOfHits) {
        this.numOfHits = numOfHits;
    }


}
