package com.designPattern.behavior.template;

public abstract class AbstractClass {
    public final void templateMethod() {
        method1();
        System.out.println("templateMethod");
        method2();
    }

    protected abstract void method1();
    protected abstract void method2();
}
