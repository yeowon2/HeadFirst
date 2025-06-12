package com.example.test.chapter02;

public class DrumKitTestDrive {
    public static void main(String[] args) {
        Drumkit drumkit = new Drumkit();

        drumkit.playSnare();
        drumkit.snare = false;
        drumkit.playTopHat();

        if (drumkit.snare)
            drumkit.playSnare();
    }
}
