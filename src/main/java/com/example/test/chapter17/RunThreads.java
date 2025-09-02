package com.example.test.chapter17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunThreads {
    public static void main(String[] args) {
        // 크기가 고정된 스레드 풀을 가진 ExecutorService를 생성
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(() -> runJob("Job 1"));
        threadPool.execute(() -> runJob("Job 2"));
        threadPool.shutdown();
    }

    private static void runJob(String jobName) {
        for (int i = 0; i < 25; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(jobName + " is running on " + threadName);
        }
    }
}
