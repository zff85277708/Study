package com.designPattern.behavior.chain.linkedList;

public class HandlerB extends Handler{
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        System.out.println("HandlerB");
        return handled;
    }
}
