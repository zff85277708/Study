package com.designPattern.found.builder;

import org.apache.commons.lang.StringUtils;

public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    @Override
    public String toString() {
        return getName() + "-" + getMaxTotal() + "-" + getMaxIdle() + "-" + getMinIdle();
    }

    //将Builder类设计成了ResourcePoolConfig的内部类
    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            //校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isBlank(name))
                throw new IllegalArgumentException("连接池名字不可为空");
            if (maxIdle > maxTotal)
                throw new IllegalArgumentException("maxIdle > maxTotal");
            if (minIdle > maxTotal || minIdle > maxIdle)
                throw new IllegalArgumentException("minIdle > maxTotal || minIdle > maxIdle");

            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name))
                throw new IllegalArgumentException("连接池名字不可为空");
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0)
                throw new IllegalArgumentException("maxTotal <= 0");
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle <= 0)
                throw new IllegalArgumentException("maxIdle <= 0");
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle <= 0)
                throw new IllegalArgumentException("minIdle <= 0");
            this.minIdle = minIdle;
            return this;
        }
    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("mysqlPool")
                .setMaxTotal(10)
                .setMaxIdle(8)
                .setMinIdle(1)
                .build();
        System.out.println(config);
    }
}

