package com.zhuff.test;

public interface cc {
    int s();

    default public String d() {
        return "";
    }
}
