package com.designPattern.auth;

import java.util.HashMap;
import java.util.Map;

public class TestAuth {
    public static void main(String[] args) {
        String baseUrl = "https://www.baidu.com/s";
        String appId = "admin";
        String password = "888888";
        long timeStamp = System.currentTimeMillis();

        Map<String, String> map = new HashMap<>();
        map.put("appId", appId);
        map.put("password", password);
        map.put("url", baseUrl);
        map.put("timeStamp", String.valueOf(timeStamp));
        CreateToken createToken = new DefaultCreateToken();
        String token = createToken.createToken(map);
        String url = baseUrl + "?appId=" + appId + "&token=" + token + "&timeStamp=" + timeStamp;
        System.out.println(url);

        //校验token
        ApiAuthenticator apiAuthenticator = new ApiAuthenticator();
        apiAuthenticator.auth(url);
    }
}
