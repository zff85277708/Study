package com.designPattern.performanceCounter;

import com.google.gson.Gson;

import java.util.Map;

/**
 * 统计数据显示到命令行
 */
public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
        System.out.println(new Gson().toJson(requestStats));
    }
}
