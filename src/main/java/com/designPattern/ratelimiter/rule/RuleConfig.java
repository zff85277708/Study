package com.designPattern.ratelimiter.rule;

import java.util.List;

/**
 * 限流配置类
 */
public class RuleConfig {
    private List<AppRuleConfig> configs;

    public RuleConfig(){}

    public RuleConfig(List<AppRuleConfig> configs) {
        this.configs = configs;
    }

    public List<AppRuleConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<AppRuleConfig> configs) {
        this.configs = configs;
    }

    /**
     * 具体应用的限流配置类
     */
    public static class AppRuleConfig{
        private String appId;
        private List<ApiLimit> limits;

        public AppRuleConfig(){}

        public AppRuleConfig(String appId, List<ApiLimit> limits) {
            this.appId = appId;
            this.limits = limits;
        }

        public String getAppId() {
            return appId;
        }

        public List<ApiLimit> getLimits() {
            return limits;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public void setLimits(List<ApiLimit> limits) {
            this.limits = limits;
        }
    }
}
