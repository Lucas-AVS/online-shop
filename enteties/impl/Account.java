package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl;

import static com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl.Account.StandardAccountOperations.MONEY_TRANSFER_SEND;
import static com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl.Account.StandardAccountOperations.WITHDRAW;

public class Account {
    private int id;
    private Transaction[] transactions;

    public Account(int id) {
        this.id = id;
        this.transactions = new Transaction[0];
    }

    enum StandardAccountOperations {
        MONEY_TRANSFER_SEND,
        MONEY_TRANSFER_RECEIVE,
        WITHDRAW;
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        Transaction[] newTransactionsArray = new Transaction[this.transactions.length + 1];
        for (int i = 0; i < this.transactions.length; i++) {
            newTransactionsArray[i] = this.transactions[i];
        }

        Transaction newTransaction =  new Transaction();
        newTransaction.accountFrom = this;
        newTransaction.accountTo = accountTo;
        newTransaction.moneyAmount = moneyAmount;
        newTransaction.operation = MONEY_TRANSFER_SEND;

        newTransactionsArray[newTransactionsArray.length - 1] = newTransaction;
        this.transactions = newTransactionsArray;
    }

    public void withdrawMoney(double moneyAmount) {
        Transaction[] newTransactionsArray = new Transaction[this.transactions.length + 1];
        for (int i = 0; i < this.transactions.length; i++) {
            newTransactionsArray[i] = this.transactions[i];
        }

        Transaction newTransaction =  new Transaction();
        newTransaction.operation = WITHDRAW;
        newTransaction.moneyAmount = moneyAmount;

        newTransactionsArray[newTransactionsArray.length - 1] = newTransaction;
        this.transactions = newTransactionsArray;
    }

    public Transaction[] getTransactions() {
        return this.transactions;
    }

    public int getId() {
        return this.id;
    }

    public static class Transaction {
        Account accountFrom;
        Account accountTo;
        double moneyAmount;
        StandardAccountOperations operation;
    }
}
