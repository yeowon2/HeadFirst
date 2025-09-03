package com.example.test.chapter18;

public class RyanAndMonicaJob implements Runnable {
    private final String name;
    private final BankAccount account;
    private final int amountToSpend;

    public RyanAndMonicaJob(String name, BankAccount account, int amountToSpend) {
        this.name = name;
        this.account = account;
        this.amountToSpend = amountToSpend;
    }

    @Override
    public void run() {
        goShopping(amountToSpend);
    }

    // BankAccount의 spend()메서드에서 자동으로 체크를 해준다면 돈을 쓰기 전에 잔고를 따로 확인할 필요가 없게 됨
    private void goShopping(int amount) {
        // 계좌 잔고를 확인해서 잔고가 충분하면 돈을 씀
        System.out.println(name + " is about to spend");
        account.spend(name, amount);
        System.out.println(name + " finishes spending");
    }
}
