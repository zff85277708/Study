package com.designPattern.idempotence;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Redis单节点实现读写幂等号
 */
public class RedisIdempotenceStorage implements IdempotenceStorage{
    private final JedisPool jedisPool;

    public RedisIdempotenceStorage() throws IOException {
        this.jedisPool = loadRedis();
    }

    public RedisIdempotenceStorage(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public boolean saveIfAbsent(String idempotenceId) {
        try (Jedis jedis = jedisPool.getResource()){
            long success = jedis.setnx(idempotenceId, "1");
            return success == 1;
        }
    }

    @Override
    public void delete(String idempotenceId) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(idempotenceId);
        }
    }

    private JedisPool loadRedis() throws IOException{
        InputStream in = this.getClass().getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        properties.load(in);
        String redisIp = properties.getProperty("redis.ip");
        String redisPort = properties.getProperty("redis.port");
        return new JedisPool(redisIp, Integer.parseInt(redisPort));
    }
}
