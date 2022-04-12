package com.designPattern.found.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举单例
 */
public enum IdGeneratorEnum {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
