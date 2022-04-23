package com.designPattern.structure.bridge;

import java.util.List;

public class TelephoneMsgSender implements MsgSender{
    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        for (String telephone : telephones) {
            System.out.println("telephone: " + telephone + ",message: " + message);
        }
    }

    @Override
    public void addList(String telephone) {
        telephones.add(telephone);
    }
}
