package com.designPattern.ratelimiter.rule;

/**
 * 缓存限流配置，方便快速查询限流信息
 */
public interface RateLimitRule {
    ApiLimit getLimit(String appId, String api);
}
