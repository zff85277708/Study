package com.designPattern.behavior.observer.syn;

public class ConcreteObserverOne implements Observer{
    @Override
    public void update(String message) {
        System.out.println("ConcreteObserverOne is notified: " + message);
    }
}
