package com.designPattern.darklaunch.rule.strategy;

/**
 * 灰度规则识别策略接口
 */
public interface IdentifyRule {
    void identify(String darkRule);
}
