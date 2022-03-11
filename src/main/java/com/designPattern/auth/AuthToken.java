package com.designPattern.auth;

import java.util.Map;

public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60*1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(CreateToken createToken, long createTime, Map<String, String> params) {
        return new AuthToken(createToken.createToken(params), createTime);
    }

    public String getToken() {
        return token;
    }

    public boolean match(AuthToken authToken){
        return this.token.equals(authToken.getToken());
    }

    public boolean isExpired() {
        long step = System.currentTimeMillis() - createTime;
        return step > expiredTimeInterval;
    }
}
