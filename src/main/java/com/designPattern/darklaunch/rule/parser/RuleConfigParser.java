package com.designPattern.darklaunch.rule.parser;

import com.designPattern.darklaunch.rule.DarkRuleConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 配置文件解析接口
 */
public interface RuleConfigParser {
    DarkRuleConfig parse(String configText) throws IOException;
    DarkRuleConfig parse(InputStream in);
}
