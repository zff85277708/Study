package com.designPattern.ratelimiter.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRateLimitRule implements RateLimitRule{
    private Map<String, ApiLimit> ruleMap = new HashMap<>();

    public MapRateLimitRule(RuleConfig ruleConfig) {
        List<RuleConfig.AppRuleConfig> appRuleConfigs = ruleConfig.getConfigs();
        for (RuleConfig.AppRuleConfig appRuleConfig : appRuleConfigs) {
            List<ApiLimit> apiLimits = appRuleConfig.getLimits();
            String appId = appRuleConfig.getAppId();
            for (ApiLimit apiLimit : apiLimits) {
                ruleMap.putIfAbsent(appId + ":" + apiLimit.getApi(), apiLimit);
            }
        }
    }

    @Override
    public ApiLimit getLimit(String appId, String api) {
        return ruleMap.get(appId + ":" + api);
    }
}
