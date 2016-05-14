package com.lijie.webSite1.model.entity;

/**
 * Created by lj on 16-3-6.
 */
public class Person {
    private int id;
    private String name;
    private int sex;
    private int age;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name, int sex, int age, String description) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
