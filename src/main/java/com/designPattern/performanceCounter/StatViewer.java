package com.designPattern.performanceCounter;

import java.util.Map;

public interface StatViewer {
    /**
     * 将统计结果显示到终端
     * @param requestStats 统计指标数据集合
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     */
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis);
}
