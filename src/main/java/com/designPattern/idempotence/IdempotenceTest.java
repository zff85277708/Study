package com.designPattern.idempotence;

import java.io.IOException;

public class IdempotenceTest {
    public static void main(String[] args) throws IOException {
        Idempotence idempotence = new Idempotence();
        String id = IdempotenceIdGenerator.generateId();
        System.out.println(id);
        System.out.println(idempotence.saveIfAbsent(id));
        System.out.println(idempotence.saveIfAbsent(id));
        idempotence.delete(id);
    }
}
