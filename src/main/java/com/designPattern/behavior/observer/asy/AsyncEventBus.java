package com.designPattern.behavior.observer.asy;

import java.util.concurrent.Executor;

public class AsyncEventBus extends EventBus{
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
