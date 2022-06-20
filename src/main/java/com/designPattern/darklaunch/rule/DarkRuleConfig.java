package com.designPattern.darklaunch.rule;

import lombok.Data;

import java.util.List;

/**
 * 灰度规则映射类
 */
@Data
public class DarkRuleConfig {
    private List<DarkFeatureConfig> features;

    @Data
    public static class DarkFeatureConfig {
        private String key;
        private boolean enabled;
        private String rule;
    }
}
