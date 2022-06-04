package com.designPattern.ratelimiter.rule;

/**
 * 具体应用下的某一接口限流配置类
 */
public class ApiLimit {
    private static final int DEFAULT_TIME_UNIT = 1; //1 second
    private String api;
    private int limit; //当前时间窗口下的接口调用次数
    private int unit = DEFAULT_TIME_UNIT; //统计时间窗口

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFAULT_TIME_UNIT);
    }

    public ApiLimit(String api, int limit, int unit) {
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

    public int getUnit() {
        return unit;
    }
}
