package com.designPattern.performanceCounter;

import com.leetcode.etc.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Redis实现存储和获取原始数据
 */
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        //for test
        List<RequestInfo> listReg = new ArrayList<>();
        listReg.add(new RequestInfo("register", 123, 10234));
        listReg.add(new RequestInfo("register", 223, 11234));
        listReg.add(new RequestInfo("register", 323, 12334));
        List<RequestInfo> listLogin = new ArrayList<>();
        listLogin.add(new RequestInfo("login", 23, 12434));
        listLogin.add(new RequestInfo("login", 1223, 14234));
        Map<String, List<RequestInfo>> map = new HashMap<>();
        map.put("register", listReg);
        map.put("login", listLogin);
        return map;
    }
}
