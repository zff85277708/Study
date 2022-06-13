package com.designPattern.idempotence;

import java.util.UUID;

/**
 * 幂等号生成
 */
public class IdempotenceIdGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
