package com.designPattern.structure.adapter.two;

/**
 * C敏感词过滤系统提供的接口
 */
public class CSensitiveWordsFilter {
    public String filter(String text, String mask) {
        return "Cfilter-" + mask + "-" + text;
    }
}
