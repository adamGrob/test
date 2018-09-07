package com.codecool.superchargetest.ejb;

import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Account {

    private BigDecimal balance;

    @OneToOne
    private Customer customer;

    @OneToMany
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account() {
    }

    public Account(BigDecimal balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }
}
