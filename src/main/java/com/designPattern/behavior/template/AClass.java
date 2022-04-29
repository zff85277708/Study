package com.designPattern.behavior.template;

public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.porcess(()-> System.out.println("Call back me."));
    }
}
