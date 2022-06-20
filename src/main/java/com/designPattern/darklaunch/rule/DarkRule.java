package com.designPattern.darklaunch.rule;

import com.designPattern.darklaunch.IDarkFeature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用HashMap存储灰度规则
 */
public class DarkRule {
    //从配置文件中加载的灰度规则
    private Map<String, IDarkFeature> darkFeatures;
    //编程实现的灰度规则
    private Map<String, IDarkFeature> programmedDarkFeatures = new ConcurrentHashMap<>();

    public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
        programmedDarkFeatures.put(featureKey, darkFeature);
    }

    public void setDarkFeatures(Map<String, IDarkFeature> newDarkFeatures) {
        this.darkFeatures = newDarkFeatures;
    }

    public IDarkFeature getDarkFeature(String featureKey) {
        IDarkFeature darkFeature = programmedDarkFeatures.get(featureKey);
        if (darkFeature != null) return darkFeature;
        return darkFeatures.get(featureKey);
    }
}
