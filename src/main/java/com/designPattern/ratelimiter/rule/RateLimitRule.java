package com.designPattern.ratelimiter.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缓存限流配置，方便快速查询限流信息
 */
public class RateLimitRule {
    private Map<String, ApiLimit> ruleMap = new HashMap<>();

    public RateLimitRule(RuleConfig ruleConfig) {
        List<RuleConfig.AppRuleConfig> appRuleConfigs = ruleConfig.getConfigs();
        for (RuleConfig.AppRuleConfig appRuleConfig : appRuleConfigs) {
            List<ApiLimit> apiLimits = appRuleConfig.getApiLimits();
            String appId = appRuleConfig.getAppId();
            for (ApiLimit apiLimit : apiLimits) {
                ruleMap.putIfAbsent(appId + ":" + apiLimit.getApi(), apiLimit);
            }
        }
    }

    public ApiLimit getLimit(String appId, String api) {
        return ruleMap.get(appId + ":" + api);
    }
}
