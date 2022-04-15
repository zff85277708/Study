package com.designPattern.performanceCounter;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.Executors;

/**
 * 负责提供 API，来采集接口请求的原始数据
 */
public class MetricsCollector {
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;
    private MetricsStorage metricsStorage;
    private EventBus eventBus;

    public MetricsCollector() {
        this(new RedisMetricsStorage(), DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    /**
     * 采集原始数据
     * @param requestInfo 原始数据信息
     */
    public void recordRequest(RequestInfo requestInfo) {
        if (null == requestInfo || StringUtils.isBlank(requestInfo.getApiName()))
            return;

        eventBus.post(requestInfo);
    }

    private class EventListener{
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }
}
