package com.example.test.chapter11;

import java.util.ArrayList;
import java.util.List;

public class SortMountains {
    public static void main(String[] args) {
        new SortMountains().go();
    }

    private void go() {
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain("Long", 14255));
        mountains.add(new Mountain("Elbert", 14433));
        mountains.add(new Mountain("Maroon", 14156));
        mountains.add(new Mountain("Castle", 14265));
        System.out.println("as entered:\n" + mountains);

        mountains.sort((one, two) -> one.getName().compareToIgnoreCase(two.getName()));
        System.out.println("by name:\n" + mountains);

        mountains.sort((one, two) -> two.getHeight() - one.getHeight());
        System.out.println("by height:\n" + mountains);
    }
}
