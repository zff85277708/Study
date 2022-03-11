package com.designPattern.auth;

import java.util.Map;

public interface CreateToken {
    String createToken(Map<String, String> params);
}
