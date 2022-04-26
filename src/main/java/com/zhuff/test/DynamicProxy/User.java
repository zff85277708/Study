package com.zhuff.test.DynamicProxy;

public class User implements IUser{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public int getAge() {
        System.out.println(age);
        return age;
    }
}
