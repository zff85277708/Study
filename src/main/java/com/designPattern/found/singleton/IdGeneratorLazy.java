package com.designPattern.found.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式单例
 */
public class IdGeneratorLazy {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorLazy idGenerator;

    private IdGeneratorLazy() {}

    public static synchronized IdGeneratorLazy getInstance() {
        if (idGenerator == null)
            idGenerator = new IdGeneratorLazy();
        return idGenerator;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
