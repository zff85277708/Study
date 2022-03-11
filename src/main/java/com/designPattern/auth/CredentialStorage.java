package com.designPattern.auth;

public interface CredentialStorage {
    String getPasswordByAppId(String appId);
}
