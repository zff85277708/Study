package com.designPattern.behavior.strategy;

public class MapReduceSort implements ISortAlg{
    @Override
    public void sort(String filePath) {
        System.out.println(this.getClass().getName());
    }
}
