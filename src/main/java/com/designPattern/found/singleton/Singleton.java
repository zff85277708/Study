package com.designPattern.found.singleton;

/**
 * 有参数的单例模式
 */
public class Singleton {
    private static Singleton singleton;
    private final int paramA;
    private final int paramB;

    private Singleton() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public synchronized static Singleton getInstance() {
        if (null == singleton)
            singleton = new Singleton();
        return singleton;
    }
}

class Config {
    public static final int PARAM_A = 123;
    public static final int PARAM_B = 245;
}
