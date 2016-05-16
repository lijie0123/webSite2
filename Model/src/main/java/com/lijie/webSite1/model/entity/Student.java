package com.lijie.webSite1.model.entity;

import com.lijie.webSite1.model.enumeration.Sex;

import java.util.Date;

/**
 * Created by lijie on 2016/4/22.
 */
public class Student {
    private String id;
    private String name;
    private Sex sex;
    private Date birthday;
    private Date moveInDay;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getMoveInDay() {
        return moveInDay;
    }

    public void setMoveInDay(Date moveInDay) {
        this.moveInDay = moveInDay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", moveInDay=" + moveInDay +
                '}';
    }
}