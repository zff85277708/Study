package com.designPattern.ratelimiter.rule.datasource;

import com.designPattern.ratelimiter.rule.RuleConfig;

/**
 * 限流规则源数据加载接口
 */
public interface RuleConfigSource {
    RuleConfig load();
}
