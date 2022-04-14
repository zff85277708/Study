package com.designPattern.performanceCounter;

import org.apache.commons.lang.StringUtils;

/**
 * 负责提供 API，来采集接口请求的原始数据
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage;

    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    /**
     * 采集原始数据
     * @param requestInfo 原始数据信息
     */
    public void recordRequest(RequestInfo requestInfo) {
        if (null == requestInfo || StringUtils.isBlank(requestInfo.getApiName()))
            return;

        metricsStorage.saveRequestInfo(requestInfo);
    }
}
