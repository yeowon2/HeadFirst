package com.example.test.chapter05;

import java.util.ArrayList;
import java.util.Scanner;

public class GameHelper {
    public int getUserInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public ArrayList<String> placeStartup(int i) {
        return null;
    }
}
