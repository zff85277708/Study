package com.designPattern.performanceCounter;

import java.util.*;

/**
 * 定时根据给定的时间区间，从数据库中取出数据
 * 借助 Aggregator 类完成统计工作，并将统计结果输出到邮件
 */
public class EmailReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailReporter(MetricsStorage metricsStorage) {
        this(metricsStorage, new EmailSender());
    }

    public EmailReporter(MetricsStorage metricsStorage, EmailSender emailSender) {
        this.metricsStorage = metricsStorage;
        this.emailSender = emailSender;
    }

    /**
     * 添加邮箱地址
     * @param address 邮箱地址
     */
    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    /**
     *定时每日0点触发拉取数据、计算统计数据、推送统计数据邮件
     */
    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //根据给定的时间区间，从数据库中拉取数据
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

                //根据原始数据，计算得到统计数据
                Map<String, RequestStat> requestStats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry: requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    requestStats.put(apiName, requestStat);
                }

                //将统计数据推送到邮箱
                for (String address: toAddresses) {
                    emailSender.send(requestStats, address);
                }
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}
