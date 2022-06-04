package com.designPattern.ratelimiter;

import com.designPattern.ratelimiter.alg.RateLimitAlg;
import com.designPattern.ratelimiter.rule.RateLimitRule;
import com.designPattern.ratelimiter.rule.RuleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private static final Logger log = LoggerFactory.getLogger(RateLimiter.class);
    //为每个api在内存中存储限流计数器
    private Map<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() {
        //将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("src/main/resources/ratelimiter-rule.yaml");
            if (in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("close file error: " + e);
                }
            }
        }

        //将限流规则构建成支持快速查找的数据结构RateLimitRule
        assert ruleConfig != null;
        this.rule = new RateLimitRule(ruleConfig);
    }
}
