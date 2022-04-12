package com.designPattern.performanceCounter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时根据给定的时间区间，从数据库中取出数据
 * 借助 Aggregator 类完成统计工作，并将统计结果输出到命令行
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * 定时触发拉取数据、计算统计数据、显示统计数据
     * @param periodInSeconds 定时任务启动间隔时间（秒）
     * @param durationInSeconds 统计的时间跨度（秒）
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            //根据给定的时间区间，从数据库中拉取数据
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos =
                    metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

            //根据原始数据，计算得到统计数据
            Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);

            //将统计数据显示到终端
            viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }
}
