package com.example.test.chapter12;

import java.util.List;
import java.util.stream.Collectors;

public class CoffeeOrder {
    public static void main(String[] args) {
        List<String> coffees = List.of(
                "Cappuccino", "Americano", "Espresso", "Cortado",
                "Mocha", "Cappuccino", "Flat White", "Latte"
        );

        List<String> coffeesEndingIn  = coffees.stream().distinct()
                .distinct()
                .filter(s -> s.endsWith("o"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(coffeesEndingIn);
    }
}
