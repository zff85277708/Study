package com.designPattern.auth;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timeStamp;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    private ApiRequest(String baseUrl, String token, String appId, long timeStamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timeStamp = timeStamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        String[] strings = url.split("\\?");
        if (strings.length != 2) throw new RuntimeException("url不合法");

        Map<String, String> map = new HashMap<>();
        map.put("baseUrl", strings[0]);
        String[] params = strings[1].split("&");
        for (String param : params) {
            String[] tmps = param.split("=");
            if (tmps.length != 2) throw new RuntimeException("url不合法");
            map.put(tmps[0], tmps[1]);
        }

        String baseUrl = map.get("baseUrl");
        String token = map.get("token");
        String appId = map.get("appId");
        long timeStamp = Long.valueOf(map.get("timeStamp"));
        return new ApiRequest(baseUrl, token, appId, timeStamp);
    }
}
