package com.designPattern.behavior.chain.linkedList;

public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);

        if (null == head) {
            head = handler;
            tail = handler;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null)
            head.handle();
    }
}
