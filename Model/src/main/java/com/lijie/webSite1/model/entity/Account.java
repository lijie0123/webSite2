package com.lijie.webSite1.model.entity;

import com.lijie.webSite1.model.enumeration.AccountType;

/**
 * Created by lijie on 2016/4/22.
 */
public class Account {
    private String id;
    private String password;
    private AccountType accountType;
    private String associateId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", associateId='" + associateId + '\'' +
                '}';
    }
}
