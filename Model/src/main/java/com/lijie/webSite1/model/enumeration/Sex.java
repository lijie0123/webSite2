package com.lijie.webSite1.model.enumeration;

/**
 * Created by lijie on 2016/4/22.
 */
public enum Sex {
    MALE(1),FEMALE(2);
    private int value;
    Sex(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
