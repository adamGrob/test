package com.codecool.superchargetest.ejb;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Customer {

    private String name;

    @OneToOne
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer() {
    }

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }
}
