package com.designPattern.darklaunch;

import com.designPattern.darklaunch.rule.DarkRule;
import com.designPattern.darklaunch.rule.datasource.FileRuleConfigSource;
import com.designPattern.darklaunch.rule.datasource.RuleConfigSource;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 灰度功能顶层入口类
 */
public class DarkLaunch {
    private static final int DEFAULT_RULE_UPDATE_TIME_INTERVAL = 60;
    private DarkRule rule;
    private ScheduledExecutorService executor;

    public DarkLaunch(int ruleUpdateTimeInterval) {
        RuleConfigSource configSource = FileRuleConfigSource.getInstance();
        this.rule = new DarkRule();
        this.rule.setDarkFeatures(configSource.loadRule());
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(() -> {
                    Map<String, IDarkFeature> features = configSource.loadRule();
                    this.rule.setDarkFeatures(features);
                },
                ruleUpdateTimeInterval, ruleUpdateTimeInterval, TimeUnit.SECONDS);
    }

    public DarkLaunch() {
        this(DEFAULT_RULE_UPDATE_TIME_INTERVAL);
    }

    //添加编程实现的灰度规则的接口
    public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
        rule.addProgrammedDarkFeature(featureKey, darkFeature);
    }

    public IDarkFeature getDarkFeature(String featureKey) {
        return rule.getDarkFeature(featureKey);
    }
}
