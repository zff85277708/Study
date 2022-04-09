package com.designPattern.performanceCounter;

import com.designPattern.auth.ApiAuthenticator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计工具类
 */
public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            count++;
            double respTime = requestInfo.getResponseTime();
            if (respTime > maxRespTime) maxRespTime = respTime;
            if (respTime < minRespTime) minRespTime = respTime;
            sumRespTime += respTime;
        }

        if (count != 0) avgRespTime = sumRespTime / count;
        long tps = count / durationInMillis * 1000;

        requestInfos.sort((o1, o2) -> {
            double diff = o1.getResponseTime() - o2.getResponseTime();
            if (diff < 0.00) return -1;
            else if (diff > 0.00) return 1;
            else return 0;
        });

        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setTps(tps);
        requestStat.setCount(count);
        return requestStat;
    }

    /**
     * 根据原始数据计算统计数据
     * @param requestInfos 原始数据集合
     * @param durationInMillis 统计的时间跨度（毫秒）
     * @return 统计指标数据集合
     */
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry: requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            respTimes.add(requestInfo.getResponseTime());
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes, durationInMillis));
        return requestStat;
    }

    private double max(List<Double> dataset) {
        double maxRespTime = Double.MIN_VALUE;
        for (double respTime : dataset) {
            maxRespTime = Double.max(maxRespTime, respTime);
        }
        return maxRespTime;
    }

    private double min(List<Double> dataset) {
        double minRespTime = Double.MAX_VALUE;
        for (double respTime : dataset) {
            minRespTime = Double.min(minRespTime, respTime);
        }
        return minRespTime;
    }

    private double avg(List<Double> dataset) {
        if (0 == dataset.size()) return -1;

        double sumRespTime = 0;
        for (double respTime : dataset) {
            sumRespTime += respTime;
        }
        return sumRespTime / dataset.size();
    }

    private double tps(List<Double> dataset, long durationInMillis) {
        return dataset.size() / (double) (durationInMillis / 1000);
    }

    private double percentile999(List<Double> dataset) {
        if (0 == dataset.size()) return -1;
        int idx999 = (int) (dataset.size() * 0.999);
        return dataset.get(idx999);
    }

    private double percentile99(List<Double> dataset) {
        if (0 == dataset.size()) return -1;
        int idx99 = (int) (dataset.size() * 0.99);
        return dataset.get(idx99);
    }
}
