package com.designPattern.ratelimiter;

public class TestLimit {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        for (int i = 0; i < 10; i++) {
            try {
                boolean flag = rateLimiter.limit("app-1", "/v1/user");
                System.out.println(flag);
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
