package com.designPattern.ratelimiter.alg;

import org.apache.maven.InternalErrorException;

/**
 * 限流算法
 */
public interface RateLimitAlg {
    boolean tryAcquire() throws InternalErrorException;
}
