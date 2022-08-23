package com.designPattern.found.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检测单例
 */
public class IdGeneratorDoubleCheck {
    private AtomicLong id = new AtomicLong(0);
    private static volatile IdGeneratorDoubleCheck idGenerator;

    private IdGeneratorDoubleCheck() {}

    public static IdGeneratorDoubleCheck getInstance() {
        if (idGenerator == null) {
            synchronized(IdGeneratorDoubleCheck.class) {
                if (idGenerator == null)
                    idGenerator = new IdGeneratorDoubleCheck();
            }
        }
        return idGenerator;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
