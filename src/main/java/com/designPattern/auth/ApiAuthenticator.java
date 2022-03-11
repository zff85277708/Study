package com.designPattern.auth;

import java.util.HashMap;
import java.util.Map;

public class ApiAuthenticator {
    private CredentialStorage credentialStorage;

    public ApiAuthenticator() {
        this.credentialStorage = new DefaultCredentialStorage();
    }

    public ApiAuthenticator(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    public void auth(String url) {
        auth(ApiRequest.createFromFullUrl(url));
    }

    public void auth(ApiRequest apiRequest) {
        String baseUrl = apiRequest.getBaseUrl();
        String token = apiRequest.getToken();
        String appId = apiRequest.getAppId();
        long timeStamp = apiRequest.getTimeStamp();

        AuthToken clientAuthToken = new AuthToken(token, timeStamp);
        if (clientAuthToken.isExpired())
            throw new RuntimeException("token过期");

        String password = credentialStorage.getPasswordByAppId(appId);
        Map<String, String> map = new HashMap<>();
        map.put("url", baseUrl);
        map.put("appId", appId);
        map.put("password", password);
        map.put("timeStamp", String.valueOf(timeStamp));
        AuthToken serverAuthToken = AuthToken.create(new DefaultCreateToken(), timeStamp, map);

        if (!serverAuthToken.match(clientAuthToken))
            throw new RuntimeException("token校验失败");
    }
}
