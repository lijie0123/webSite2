package com.lijie.webSite1.model.entity;

import com.lijie.webSite1.model.enumeration.Sex;

import java.util.Date;

/**
 * Created by lijie on 2016/5/16.
 */
public class Teacher {
    private String id;
    private String name;
    private Sex sex;
    private Date birthday;
    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", title='" + title + '\'' +
                '}';
    }
}
