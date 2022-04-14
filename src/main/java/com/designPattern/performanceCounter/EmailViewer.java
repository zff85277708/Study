package com.designPattern.performanceCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 统计数据推送到邮箱
 */
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this(new EmailSender());
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer(List<String> toAddresses) {
        this(new EmailSender());
        this.toAddresses = toAddresses;
    }

    /**
     * 添加邮箱地址
     * @param address 邮箱地址
     */
    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        System.out.println("Email Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
        for (String address: toAddresses) {
            emailSender.send(requestStats, address);
        }
    }
}
