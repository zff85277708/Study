package com.designPattern.structure.bridge;

import java.util.List;

public class WechatMsgSender implements MsgSender{
    private List<String> wechats;

    public WechatMsgSender(List<String> wechats) {
        this.wechats = wechats;
    }

    @Override
    public void send(String message) {
        for (String wechat : wechats) {
            System.out.println("wechat: " + wechat + ",message: " + message);
        }
    }

    @Override
    public void addList(String wechat) {
        wechats.add(wechat);
    }
}
