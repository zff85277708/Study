package com.designPattern.darklaunch;

import com.designPattern.darklaunch.rule.DarkRuleConfig.DarkFeatureConfig;
import com.designPattern.darklaunch.rule.strategy.*;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.apache.commons.lang3.StringUtils;

/**
 * 基于配置文件的灰度规则
 */
public class DarkFeature implements IDarkFeature{
    private String key;
    private boolean enabled;
    private int percentage;
    private RangeSet<Long> rangeSet = TreeRangeSet.create();

    public DarkFeature(DarkFeatureConfig darkFeatureConfig) {
        this.key = darkFeatureConfig.getKey();
        this.enabled = darkFeatureConfig.isEnabled();
        String darkRule = darkFeatureConfig.getRule().trim();
        parseDarkRule(darkRule);
    }

    private void parseDarkRule(String darkRule) {
        String[] rules = darkRule.split(",");
        rangeSet.clear();
        percentage = 0;
        for (String rule : rules) {
            rule = rule.trim();
            if (StringUtils.isEmpty(rule)) continue;

            IdentifyRule identifyRule = IdentifyRuleFactory.getIdentifyRule(rule);
            if (identifyRule instanceof IdentifyPercentage)
                percentage = ((IdentifyPercentage) identifyRule).getPercentage();
            else if (identifyRule instanceof IdentifyRange)
                rangeSet.add(((IdentifyRange) identifyRule).getRange());
            else if (identifyRule instanceof IdentifyNum)
                rangeSet.add(((IdentifyNum) identifyRule).getRange());
        }
    }

    @Override
    public boolean enabled() {
        return enabled;
    }

    @Override
    public boolean dark(long darkTarget) {
        if (!enabled()) return false;

        boolean selected = rangeSet.contains(darkTarget);
        if (selected) return true;

        long reminder = darkTarget % 100;
        return reminder >= 0 && reminder < percentage;
    }

    @Override
    public boolean dark(String darkTarget) {
        return dark(Long.parseLong(darkTarget));
    }

    public String getKey() {
        return key;
    }
}
