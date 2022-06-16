package com.designPattern.ratelimiter;

import com.designPattern.ratelimiter.alg.FixedTimeWinRateLimitAlg;
import com.designPattern.ratelimiter.alg.RateLimitAlg;
import com.designPattern.ratelimiter.rule.ApiLimit;
import com.designPattern.ratelimiter.rule.MapRateLimitRule;
import com.designPattern.ratelimiter.rule.RateLimitRule;
import com.designPattern.ratelimiter.rule.RuleConfig;
import com.designPattern.ratelimiter.rule.datasource.FileRuleConfigSource;
import com.designPattern.ratelimiter.rule.datasource.RuleConfigSource;
import org.apache.maven.InternalErrorException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 限流规则上帝类
 */
public class RateLimiter {
    //为每个api在内存中存储限流计数器
    private Map<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() {
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();

        //将限流规则构建成支持快速查找的数据结构RateLimitRule
        assert ruleConfig != null;
        this.rule = new MapRateLimitRule(ruleConfig);
    }

    /**
     * 限流规则使用入口方法
     * @param appId 应用名
     * @param url url
     * @return true-未达到限流标准；false-限流
     * @throws InternalErrorException 内部异常
     */
    public boolean limit(String appId, String url) throws InternalErrorException {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) return true;

        //获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit(), apiLimit.getUnit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }

        //判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}
