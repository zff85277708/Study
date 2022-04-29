package com.designPattern.behavior.observer.asy;

public class Observer2 {
    @NewSubscribe
    public void say(A a) {
        System.out.println("Observer2-say: " + a.MESSAGE);
    }

    @NewSubscribe
    public void tell(B b) {
        System.out.println("Observer2-tell: " + b.MESSAGE);
    }
}
