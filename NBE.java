package org.example;

public class NBE extends Bank {
    private double balance;
    public static final double MAX_WITHDRAWAL = 8000;
    public static final double MAX_DEPOSIT = 15000;

    private final String bankName = "NBE";

    public NBE() {

    }

    public NBE(double initialBalance) {
        balance = initialBalance;
    }
    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public void withDraw(double amount) {
        if (amount > MAX_WITHDRAWAL) {
            System.err.printf("Cannot withdraw more than %f in one transaction.%n", MAX_WITHDRAWAL);
        }

        if (amount > balance) {
            System.err.printf("Not enough balance");
        }

        balance -= amount;
        System.out.printf("Withdrew %f%nCurrent balance: %f%n", amount, balance);
    }

    @Override
    public double getWithdrawLimit() {
        return 0;
    }

    @Override
    public void deposit(double amount) {
        if (amount > MAX_DEPOSIT) {
            System.err.printf("Cannot deposit more than %f in one transaction.%n", MAX_DEPOSIT);
        }

        balance += amount;
        System.out.printf("Deposited %f%nCurrent balance: %f%n", amount, balance);
    }

    @Override
    public double getDepositLimit() {
        return 0;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public void exchangeMoney(double amount, String currency) {
        if (amount > balance){
            System.out.println("account money not enough ");
        }
        else if (amount <= balance && currency.equals("Dollar")) {
            double result_after_exchange=amount / 30.8500;
            balance-=amount;
            System.out.println("you exhange " + amount + " EGP " + " successfully to " + result_after_exchange + " USD");

        }
        else if (amount <= balance && currency.equals("Euro")) {
            double result_after_exchange=amount / 33.4815;
            balance-=amount;
            System.out.println("you exhange " + amount + " EGP " + " successfully to " + result_after_exchange  + " EUR");

        }
        else if (amount <= balance && currency.equals("Sar")) {
            double result_after_exchange=amount / 8.2262;
            balance-=amount;
            System.out.println("you exhange " + amount + " EGP " + " successfully to " + result_after_exchange  + " Sar");

        }
    }
}
