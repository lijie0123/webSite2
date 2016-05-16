package com.lijie.webSite1.model.enumeration;

/**
 * Created by lijie on 2016/4/22.
 */
public enum Sex {
    MALE(1),FEMALE(2),Other(3);
    private int value;
    Sex(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public static Sex toSex(int value){
        switch (value){
            case 1:return MALE;
            case 2:return FEMALE;
            case 3:return Other;
            default:return null;
        }
    }
}
