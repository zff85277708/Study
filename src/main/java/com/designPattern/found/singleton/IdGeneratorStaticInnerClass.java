package com.designPattern.found.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类单例
 */
public class IdGeneratorStaticInnerClass {
    private AtomicLong id = new AtomicLong(0);

    private IdGeneratorStaticInnerClass() {}

    private static class SingletonHolder {
        private static final IdGeneratorStaticInnerClass idGenerator = new IdGeneratorStaticInnerClass();
    }

    public static IdGeneratorStaticInnerClass getInstance() {
        return SingletonHolder.idGenerator;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
