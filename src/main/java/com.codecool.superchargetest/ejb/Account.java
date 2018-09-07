package com.codecool.superchargetest.ejb;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private BigDecimal balance;

    @OneToOne
    private Customer customer;

    @OneToMany
    private List<Transaction> transactions;

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
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

    public Account(int id, BigDecimal balance, Customer customer, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.customer = customer;
        this.transactions = transactions;
    }
}
