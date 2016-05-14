package com.lijie.webSite1.model.enumeration;

/**
 * Created by lijie on 2016/4/22.
 */
public enum AccountType {
    ADMIN(0),
    TEACHER(1),
    STUDENT(2);

    private int value;
    AccountType(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
    public static AccountType toAccountType(int value){
        switch (value){
            case 0: return ADMIN;
            case 1: return TEACHER;
            case 2: return STUDENT;
            default:return null;
        }
    }
}
