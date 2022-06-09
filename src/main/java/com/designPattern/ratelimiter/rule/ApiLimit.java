package com.designPattern.ratelimiter.rule;

/**
 * 具体应用下的某一接口限流配置类
 */
public class ApiLimit {
    private static final long DEFAULT_TIME_UNIT = 1000; //1 second
    private String api;
    private int limit; //当前时间窗口下的接口调用次数
    private long unit = DEFAULT_TIME_UNIT; //统计时间窗口

    public ApiLimit(){}

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFAULT_TIME_UNIT);
    }

    public ApiLimit(String api, int limit, long unit) {
        this.api = api;
        this.limit = limit;
        this.unit = unit;
    }

    public String getApi() {
        return api;
    }

    public int getLimit() {
        return limit;
    }

    public long getUnit() {
        return unit;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setUnit(long unit) {
        this.unit = unit;
    }
}
