package com.designPattern.performanceCounter;

import java.util.List;
import java.util.Map;

/**
 * 原始数据的存储与获取
 */
public interface MetricsStorage {
    /**
     * 存储原始数据
     * @param requestInfo 原始数据信息
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 根据接口名、时间点获取当前接口下的原始数据信息列表
     * @param apiName 接口名
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     * @return 当前接口下的原始数据信息列表
     */
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    /**
     * 根据时间点获取所有接口下的原始数据信息列表
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     * @return 所有接口下的原始数据信息列表
     */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
