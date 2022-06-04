package com.designPattern.ratelimiter.rule;

import java.util.List;

/**
 * 限流配置文件
 */
public class RuleConfig {
    private List<AppRuleConfig> configs;

    public RuleConfig(List<AppRuleConfig> configs) {
        this.configs = configs;
    }

    public List<AppRuleConfig> getConfigs() {
        return configs;
    }

    /**
     * 具体应用的限流配置类
     */
    public static class AppRuleConfig{
        private String appId;
        private List<ApiLimit> apiLimits;

        public AppRuleConfig(String appId, List<ApiLimit> apiLimits) {
            this.appId = appId;
            this.apiLimits = apiLimits;
        }

        public String getAppId() {
            return appId;
        }

        public List<ApiLimit> getApiLimits() {
            return apiLimits;
        }
    }
}
