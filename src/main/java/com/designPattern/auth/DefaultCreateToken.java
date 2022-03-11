package com.designPattern.auth;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

public class DefaultCreateToken implements CreateToken{

    @Override
    public String createToken(Map<String, String> params) {
        String url = params.get("url");
        String appId = params.get("appId");
        String password = params.get("password");
        String timeStamp = params.get("timeStamp");
        return DigestUtils.md5Hex(url + appId+ password + timeStamp);
    }
}
