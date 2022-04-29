package com.designPattern.behavior.template;

public class BClass {
    public void porcess(ICallback callback) {
        System.out.println("porcess");
        callback.methodToCallback();
    }
}
