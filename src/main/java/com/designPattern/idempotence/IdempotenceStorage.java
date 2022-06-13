package com.designPattern.idempotence;

/**
 * 用来读写幂等号
 */
public interface IdempotenceStorage {
    boolean saveIfAbsent(String idempotenceId);
    void delete(String idempotenceId);
}
