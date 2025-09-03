package com.example.test.chapter18;

import java.util.concurrent.atomic.AtomicInteger;

public class Balance {
    // int 대신 0으로 초기화한 AtomicInterger 사용 > 원자적 연산 사용하므로 synchronized 필요 x
    AtomicInteger balance = new AtomicInteger(0);

    // 우리가 balance 값을 읽는 순간의 값에 1을 더하고 잔고 값을 1 증가시킴
    // ++ 연산자가 원자적 연산이라고 생각할 수 있지만 실제로는 그렇지 않음
    public void increment() {
        balance.incrementAndGet();
    }
}
