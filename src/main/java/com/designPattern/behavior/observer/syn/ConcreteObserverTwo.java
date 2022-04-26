package com.designPattern.behavior.observer.syn;

public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(String message) {
        System.out.println("ConcreteObserverTwo is notified: " + message);
    }
}
