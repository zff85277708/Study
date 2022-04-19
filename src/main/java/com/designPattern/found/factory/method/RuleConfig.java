package com.designPattern.found.factory.method;

public class RuleConfig {
    private String name;

    public RuleConfig(String name) {
        this.name = name;
    }
    public String show() {
        return name;
    }
}
