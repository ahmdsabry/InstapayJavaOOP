package org.example;

import java.util.ArrayList;

public class UserAccount {
    private String Username;
    private ArrayList<BankAccount> accounts= new ArrayList<>();
    private String password;

    public String getUsername() {
        return Username;
    }

    public UserAccount(String username, String password) {
        this.Username = username;
        this.password = password;
    }
    public boolean isPasswordValid(String password){
        if (this.password.equals(password)){
            return true;
        }
        return false;
    }

    public void addBankAccount(BankAccount acc){
        accounts.add(acc);
    }
    public void showBankAccounts() {
        for (int i = 1; i <= accounts.size(); i++) {
            System.out.printf("%d - %s", i, accounts.get(i-1).getBankName()+"\n");
        }
    }
    public  BankAccount getBankAccount(int index) {
        if (index < 0 || index >= accounts.size()) {
            return null;
        }
        return accounts.get(index);
    }



//    @Override
//    public String toString() {
//        return String.format("%s, %s, %f",
//                getName(), getBalance());
//    }
}
