package com.designPattern.behavior.observer.syn;

public class Demo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserverOne();
        Observer observer2 = new ConcreteObserverTwo();
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.notifyObservers("notify");
        subject.removeObserver(observer1);
        subject.notifyObservers("delete");
    }
}
