package com.example.test.chapter18;

import java.util.concurrent.atomic.AtomicInteger;

// 두 스레드에서 사용하는 BankAccount 인스턴스를 잠글 것
public class BankAccount {
    // 잔고 100에서 시작
    private final AtomicInteger balance = new AtomicInteger(100);

    public int getBalance() {
        return balance.get();
    }

    public void spend(String name, int amount) {
        int initalBalance = getBalance();
        if (initalBalance >= amount) {
            boolean success = balance.compareAndSet(initalBalance, initalBalance - amount);

            if (!success) {
                System.out.println("Sorry " + name + ", you haven't spend the money.");
            } else {
                System.out.println("Sorry, not enough for " + name);
            }
        }
    }
}
