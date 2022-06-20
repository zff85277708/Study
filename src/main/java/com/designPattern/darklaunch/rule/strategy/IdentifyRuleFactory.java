package com.designPattern.darklaunch.rule.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 灰度规则策略工厂方法
 */
public class IdentifyRuleFactory {
    private static final Map<String, IdentifyRule> IDENTIFY_RULE_MAP = new HashMap<>();

    static {
        IDENTIFY_RULE_MAP.put("Num", new IdentifyNum());
        IDENTIFY_RULE_MAP.put("Percentage", new IdentifyPercentage());
        IDENTIFY_RULE_MAP.put("Range", new IdentifyRange());
    }

    public static IdentifyRule getIdentifyRule(String rule) {
        IdentifyRule identifyRule;
        if (rule.endsWith("%")) {
            identifyRule = IDENTIFY_RULE_MAP.get("Percentage");
            identifyRule.identify(rule);
        } else if (rule.contains("-")) {
            identifyRule = IDENTIFY_RULE_MAP.get("Range");
            identifyRule.identify(rule);
        } else {
            identifyRule = IDENTIFY_RULE_MAP.get("Num");
            identifyRule.identify(rule);
        }
        return identifyRule;
    }
}
