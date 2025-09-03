package com.example.test.chapter18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LostUpdate {
    public static void main(String[] args) throws InterruptedException {
        // 모든 작업을 처리할 스레드 풀 생성
        // 더 많은 스레드를 더할수록 제대로 갱신이 안 되는 경우가 더 많아짐
        ExecutorService pool = Executors.newFixedThreadPool(6);

        Balance balance = new Balance();
        // 서로 다른 스레드에서 잔고를 1000번 갱신함
        for (int i = 0; i < 1000; i++) {
            pool.execute(balance::increment);
        }
        pool.shutdown();

        if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
            // 잔고의 최종값을 출력하기 전에 스레드 풀에서 모든 갱신 작업을 처리하도록 해야 함
            // 이론적으로는 최종 값이 1000이어야 함 그보다 값이 작다면 갱신 손실 발생
            System.out.println("Balance is: " + balance.balance);
        }
    }
}
