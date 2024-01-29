package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void exhangeOption() {
        System.out.println("Select the  currency: ");
        System.out.println("1 - Dollar");
        System.out.println("2 - Euro");
        System.out.println("3 - Sar");
        System.out.println("4 - back to main page ");
        System.out.println("\n");
    }
    public static void sideMenu() {
        System.out.println("Select your Operation : ");
        System.out.println("1 - Withdraw");
        System.out.println("2 - Deposit");
        System.out.println("3 - Show Balance");
        System.out.println("4 - Exchange Currency of your balance");
        System.out.println("5 - Back To Main");
    }

    public static void main(String[] args) {
        // User interface

        //variables
        int option;
        int operation;
        double amount;
        BankAccount bank = null;
        String password = "";
        Scanner input = new Scanner(System.in);
        List<UserAccount> users = new ArrayList<UserAccount>();
        UserAccount user = null;

        // test cases of several accounts
        UserAccount user1 = new UserAccount("abc", "1234");
        user1.addBankAccount(new CIB(1000));
        user1.addBankAccount(new NBE(1000));
        user1.addBankAccount(new BanqueMisr(0));
        user1.addBankAccount(new QNB(5000));
        users.add(user1);


        //start of the program
        System.out.println("Welcome Enter your password : ");

        while (user == null) {
            password = input.next();
            for (UserAccount u: users) {
                if (u.isPasswordValid(password)) {
                    user = u;
                    break;
                }
            }

            if (user == null) {
                System.out.println("Invalid User\n");
                System.out.println("Enter your password : ");
            }
        }

        while (bank == null) {
            user.showBankAccounts();
            option = input.nextInt();

            if (user.getBankAccount(option - 1) == null) {
                System.out.println("Invalid Choice\n");
                System.out.println("===================================\n");
            }

            else {
                bank = user.getBankAccount(option - 1);
                boolean repeat = true;
                while (repeat) {
                    sideMenu();
                    operation = input.nextInt();

                    if (operation == 1) {
                        System.out.println("Enter the amount : ");
                        amount = input.nextDouble();
                        bank.withDraw(amount);
                    }

                    else if (operation == 2) {
                        System.out.println("Enter the amount : ");
                        amount = input.nextDouble();
                        bank.deposit(amount);
                    }

                    else if (operation == 3) {
                        System.out.println("Your balance is : " + bank.showBalance() + " EGP");
                    }

                    else if (operation == 4) {
                        boolean flag = true;
                        while (flag) {
                            exhangeOption();
                            option = input.nextInt();
                            switch (option) {
                                case 1:
                                    System.out.println("Enter the amount : ");
                                    amount = input.nextDouble();
                                    bank.exchangeMoney(amount, "Dollar");
                                    break;
                                case 2:
                                    System.out.println("Enter the amount : ");
                                    amount = input.nextDouble();
                                    bank.exchangeMoney(amount, "Euro");
                                    break;
                                case 3:
                                    System.out.println("Enter the amount : ");
                                    amount = input.nextDouble();
                                    bank.exchangeMoney(amount, "Sar");
                                    break;
                                case 4:
                                    flag = false;
                                    break;

                                default:
                                    System.out.println("Invalid Choice\n");
                                    System.out.println("===================================\n");
                            }
                        }

                    }

                    else if (operation == 5) {
                        repeat = false;
                        bank = null;
                    }

                    else {
                        System.out.println("Invalid Choice\n");
                        System.out.println("===================================\n");
                    }

                }
            }
        }
    }
}
