package com.example.test.chapter18;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentReaders {
    public static void main(String[] args) {
        List<Chat> chatHistory = new CopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> chatHistory.add(new Chat("HI THERE!!")));
            executor.execute(() -> System.out.println(chatHistory));
            executor.execute(() -> System.out.println(chatHistory));
        }

        executor.shutdown();
    }
}
