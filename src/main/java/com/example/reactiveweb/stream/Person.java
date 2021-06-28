package com.example.reactiveweb.stream;

import lombok.Data;

/**
 * 人员
 * @author Administrator
 */
@Data
public class Person {
    private String name;
    private Integer age;
    private String country;
    private char sex;

    public Person(String name, Integer age, String country, char sex) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.sex = sex;
    }
}