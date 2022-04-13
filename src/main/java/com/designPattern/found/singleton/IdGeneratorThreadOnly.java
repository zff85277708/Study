package com.designPattern.found.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一单例模式
 */
public class IdGeneratorThreadOnly {
    private AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, IdGeneratorThreadOnly> instances = new ConcurrentHashMap<>();

    private IdGeneratorThreadOnly() {}

    public static IdGeneratorThreadOnly getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGeneratorThreadOnly());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
