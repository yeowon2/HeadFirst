package com.example.test.chapter18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RyanAndMonicaTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        RyanAndMonicaJob ryan = new RyanAndMonicaJob("Ryan", account, 50);
        RyanAndMonicaJob monica = new RyanAndMonicaJob("Monica", account, 100);
        // 두 작업을 위해 두 개의 스레드가 있는 스레드 풀 새로 만듦
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 두 작업 실행
        executor.execute(ryan);
        executor.execute(monica);
        // 스레드풀 셧다운
        executor.shutdown();
    }
}
