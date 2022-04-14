package com.designPattern.performanceCounter;

import com.google.common.annotations.VisibleForTesting;

import java.util.*;

/**
 * 定时根据给定的时间区间，从数据库中取出数据
 * 借助 Aggregator 类完成统计工作，并将统计结果输出到邮件
 */
public class EmailReporter extends ScheduledReporter{
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    public EmailReporter(List<String> emailToAddresses) {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer(emailToAddresses));
    }

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }

    /**
     *定时每日0点触发拉取数据、计算统计数据、推送统计数据邮件
     */
    public void startDailyReport() {
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    /**
     * 生成任务首次启动时间
     * @return 首次启动时间
     */
    @VisibleForTesting
    protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
        //这里可以获取当前时间
        Calendar calendar = Calendar.getInstance();
        //重新设置时间
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return  calendar.getTime();
    }
}
