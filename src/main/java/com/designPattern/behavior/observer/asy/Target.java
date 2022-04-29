package com.designPattern.behavior.observer.asy;

import java.util.List;
import java.util.concurrent.Executors;

public class Target {
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public Target() {
//        eventBus = new EventBus();
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers)
            eventBus.register(observer);
    }

    public void run() {
        System.out.println("attention!!!");
        eventBus.post(new B());
    }
}
