package com.designPattern.behavior.observer.asy;

public class Observer1 {
    @NewSubscribe
    public void say(A a) {
        System.out.println("Observer1-say: " + a.MESSAGE);
    }
}
