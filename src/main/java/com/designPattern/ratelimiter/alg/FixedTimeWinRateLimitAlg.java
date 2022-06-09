package com.designPattern.ratelimiter.alg;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import org.apache.maven.InternalErrorException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 固定窗口限流
 */
public class FixedTimeWinRateLimitAlg implements RateLimitAlg{
    private static final long TRY_LOCK_TIMEOUT = 200L;
    private final Stopwatch stopwatch;
    private final AtomicInteger currentCount = new AtomicInteger(0);
    private final int limit;
    private final long unit;
    private final Lock lock = new ReentrantLock();

    public FixedTimeWinRateLimitAlg(int limit, long unit) {
        this(limit, unit, Stopwatch.createStarted());
    }

    @VisibleForTesting
    protected FixedTimeWinRateLimitAlg(int limit, long unit, Stopwatch stopwatch) {
        this.limit = limit;
        this.unit = unit;
        this.stopwatch = stopwatch;
    }

    @Override
    public boolean tryAcquire() throws InternalErrorException {
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit) return true;

        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.MILLISECONDS.toMillis(unit)) {
                        currentCount.set(0);
                        stopwatch.reset().start();
                        updatedCount = currentCount.incrementAndGet();
                    }
                    return updatedCount <= limit;
                } finally {
                    lock.unlock();
                }
            } else {
                throw new InternalErrorException("tryAcquire() wait lock too long: " + TRY_LOCK_TIMEOUT + "ms", null);
            }
        } catch (InterruptedException e) {
            throw new InternalErrorException("tryAcquire() is interrupted by lock-time-out.", e);
        }
    }
}
