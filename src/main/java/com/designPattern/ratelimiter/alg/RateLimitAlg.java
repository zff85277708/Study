package com.designPattern.ratelimiter.alg;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import org.apache.maven.InternalErrorException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimitAlg {
    private static final long TRY_LOCK_TIMEOUT = 200L;
    private final Stopwatch stopwatch;
    private final AtomicInteger currentCount = new AtomicInteger(0);
    private final int limit;
    private final Lock lock = new ReentrantLock();

    public RateLimitAlg(int limit) {
        this(limit, Stopwatch.createStarted());
    }

    @VisibleForTesting
    protected RateLimitAlg(int limit, Stopwatch stopwatch) {
        this.limit = limit;
        this.stopwatch = stopwatch;
    }

    public boolean tryAcquire() throws InternalErrorException {
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit) return true;

        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
                        currentCount.set(0);
                        stopwatch.reset();
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
