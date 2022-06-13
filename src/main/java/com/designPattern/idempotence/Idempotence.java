package com.designPattern.idempotence;

import java.io.IOException;

/**
 * 幂等框架上帝类
 */
public class Idempotence {
    private final IdempotenceStorage storage;

    public Idempotence() throws IOException {
        this.storage = new RedisIdempotenceStorage();
    }

    public Idempotence(IdempotenceStorage storage) {
        this.storage = storage;
    }

    public boolean saveIfAbsent(String idempotenceId) {
        return storage.saveIfAbsent(idempotenceId);
    }

    public void delete(String idempotenceId) {
        storage.delete(idempotenceId);
    }
}
