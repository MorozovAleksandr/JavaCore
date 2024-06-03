package main.java;

import main.java.interfaces.BankAccount;

public class Account implements BankAccount {
    private String accNumber;
    private int balance;

    public String getAccNumber() {
        return accNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public Account(String accNumber, int balance) {
        this.accNumber = accNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber='" + accNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
