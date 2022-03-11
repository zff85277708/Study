package com.designPattern.auth;

public class DefaultCredentialStorage implements CredentialStorage{
    @Override
    public String getPasswordByAppId(String appId) {
        return "888888";
    }
}
