package com.charter.rewards.controller.entity;

import java.time.LocalDate;


public class CustomerTransaction {

    int customerId;
    double amount;
    LocalDate transactionDate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "CustomerTransaction{" +
                "customerId=" + customerId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
