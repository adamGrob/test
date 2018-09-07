package com.codecool.superchargetest.ejb;

import com.codecool.superchargetest.model.TransActionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Account account;

    private TransActionType transActionType;

    private Date date;

    private BigDecimal transactionAmount;

    private BigDecimal balanceAtTransAction;

    public Transaction() {
    }

    public Transaction(int id, Account account, TransActionType transActionType, Date date, BigDecimal transactionAmount, BigDecimal balanceAtTransAction) {
        this.id = id;
        this.account = account;
        this.transActionType = transActionType;
        this.date = date;
        this.transactionAmount = transactionAmount;
        this.balanceAtTransAction = balanceAtTransAction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransActionType getTransActionType() {
        return transActionType;
    }

    public void setTransActionType(TransActionType transActionType) {
        this.transActionType = transActionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getBalanceAtTransAction() {
        return balanceAtTransAction;
    }

    public void setBalanceAtTransAction(BigDecimal balanceAtTransAction) {
        this.balanceAtTransAction = balanceAtTransAction;
    }
}
