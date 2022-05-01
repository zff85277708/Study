package com.designPattern.behavior.strategy;

public class ConcurrentExternalSort implements ISortAlg{
    @Override
    public void sort(String filePath) {
        System.out.println(this.getClass().getName());
    }
}
