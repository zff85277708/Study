package com.designPattern.darklaunch.rule.datasource;

import com.designPattern.darklaunch.IDarkFeature;

import java.util.Map;

/**
 * 灰度规则源数据加载接口
 */
public interface RuleConfigSource {
    Map<String, IDarkFeature> loadRule();
}
