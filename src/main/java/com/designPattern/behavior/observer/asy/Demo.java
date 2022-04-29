package com.designPattern.behavior.observer.asy;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Target target = new Target();
        List<Object> observers = new ArrayList<>();
        observers.add(new Observer1());
        observers.add(new Observer2());
        target.setRegObservers(observers);
        target.run();
    }
}
