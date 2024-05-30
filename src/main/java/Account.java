package main.java;

import main.java.interfaces.BankAccount;

public class Account implements BankAccount {
    private String accNumber;
    private double balance;

    public String getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}
