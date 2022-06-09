package com.designPattern.ratelimiter.rule.parser;

import com.designPattern.ratelimiter.rule.RuleConfig;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 配置文件解析接口
 */
public interface RuleConfigParser {
    RuleConfig parse(String configText) throws FileNotFoundException;
    RuleConfig parse(InputStream in);
}
