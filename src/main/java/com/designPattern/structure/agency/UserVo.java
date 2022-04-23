package com.designPattern.structure.agency;

public class UserVo {
    private String name;
    private Integer age;

    public UserVo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name + ",age: " + age;
    }
}
