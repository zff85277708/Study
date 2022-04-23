package com.designPattern.structure.bridge;

import java.util.ArrayList;

public class BridgeTest {
    public static void main(String[] args) {
        MsgSender telephoneMsgSender = new TelephoneMsgSender(new ArrayList<>());
        telephoneMsgSender.addList("13916263601");
        telephoneMsgSender.addList("15051269846");
        Notification severe = new SevereNotification(telephoneMsgSender);
        severe.notify("severe!!!");

        MsgSender emailMsgSender = new EmailMsgSender(new ArrayList<>());
        emailMsgSender.addList("602192932@qq.com");
        emailMsgSender.addList("zff85277708@163.com");
        Notification urgency = new UrgencyNotification(emailMsgSender);
        urgency.notify("urgency!!");

        MsgSender wechatMsgSender = new WechatMsgSender(new ArrayList<>());
        wechatMsgSender.addList("w-zhuff");
        wechatMsgSender.addList("w-gumin");
        Notification normal = new NormalNotification(wechatMsgSender);
        normal.notify("normal!");

        Notification trivial = new TrivialNotification(telephoneMsgSender);
        trivial.notify("trivial");

    }
}
