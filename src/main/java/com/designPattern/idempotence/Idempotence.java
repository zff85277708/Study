package com.designPattern.idempotence;

import com.sun.org.apache.regexp.internal.RE;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

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
