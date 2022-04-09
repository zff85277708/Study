package com.designPattern.performanceCounter;

import com.google.gson.Gson;

import java.util.Map;

/**
 * 邮件发送类
 */
public class EmailSender {
    /**
     * 发送统计数据邮件
     * @param requestStats 统计数据列表
     * @param address 邮箱地址
     */
    public void send(Map<String, RequestStat> requestStats, String address) {
        System.out.println(address);
        System.out.println(new Gson().toJson(requestStats));
    }
}
