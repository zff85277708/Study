package com.designPattern.performanceCounter;

import com.google.gson.Gson;

import java.util.HashMap;
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
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
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
            Map<String, RequestStat> requestStats = new HashMap<>();
            for (Map.Entry<String, List<RequestInfo>> entry: requestInfos.entrySet()) {
                String apiName = entry.getKey();
                List<RequestInfo> requestInfosPerApi = entry.getValue();
                RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                requestStats.put(apiName, requestStat);
            }

            //将统计数据显示到终端
            System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
            System.out.println(new Gson().toJson(requestStats));
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
