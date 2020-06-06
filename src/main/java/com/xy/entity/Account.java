package com.xy.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer accId;
    private String accName;
    private Double balance;
    private Integer userId;

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", accName='" + accName + '\'' +
                ", balance=" + balance +
                ", userId=" + userId +
                '}';
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
