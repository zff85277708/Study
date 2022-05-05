package com.designPattern.behavior.chain.linkedList;

public class HandlerA extends Handler{
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        System.out.println("HandlerA");
        return handled;
    }
}
