package com.designPattern.found.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式单例
 */
public class IdGeneratorStatic {
    private AtomicLong id = new AtomicLong(0);
    private static final IdGeneratorStatic idGenerator = new IdGeneratorStatic();

    private IdGeneratorStatic() {}

    public static IdGeneratorStatic getInstance() {
        return idGenerator;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
