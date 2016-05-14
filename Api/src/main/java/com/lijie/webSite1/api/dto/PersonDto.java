package com.lijie.webSite1.api.dto;

/**
 * Created by lj on 16-3-6.
 */
public class PersonDto {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PersonDto() {
    }

    public PersonDto(int id, String name, String sex, int age, String desc) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", desc='" + desc + '\'' ;
    }
}
