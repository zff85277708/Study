package com.designPattern.behavior.strategy;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SortAlgFactory {
    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (StringUtils.isBlank(type))
            throw new IllegalArgumentException("type should not be empty.");
        return algs.get(type);
    }
}
