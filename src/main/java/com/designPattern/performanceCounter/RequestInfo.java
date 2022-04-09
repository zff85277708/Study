package com.designPattern.performanceCounter;

/**
 * 封装采集到的原始数据信息
 */
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timeStamp;

    public RequestInfo(String apiName, double responseTime, long timeStamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timeStamp = timeStamp;
    }

    public String getApiName() {
        return apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
