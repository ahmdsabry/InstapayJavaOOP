package org.example;

public interface BankAccount {
    String getBankName();
    void withDraw(double amount);

    double getWithdrawLimit();

    void deposit(double amount);

    double getDepositLimit();

    double showBalance();
    void exchangeMoney(double amount, String currency);

}
