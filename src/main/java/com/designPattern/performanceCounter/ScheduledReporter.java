package com.designPattern.performanceCounter;

import java.util.List;
import java.util.Map;

/**
 * 将统计显示的公共部分抽取成抽象类
 */
public abstract class ScheduledReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    /**
     * 拉取数据、计算统计数据、显示统计数据
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     */
    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        //根据给定的时间区间，从数据库中拉取数据
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

        //根据原始数据，计算得到统计数据
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);

        //将统计数据显示到终端
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }
}
