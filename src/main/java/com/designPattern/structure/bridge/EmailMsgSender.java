package com.designPattern.structure.bridge;

import java.util.List;

public class EmailMsgSender implements MsgSender{
    private List<String> emails;

    public EmailMsgSender(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void send(String message) {
        for (String email : emails) {
            System.out.println("email: " + email + ",message: " + message);
        }
    }

    @Override
    public void addList(String email) {
        emails.add(email);
    }
}
