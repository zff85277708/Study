package com.designPattern.structure.adapter.two;

/**
 * B敏感词过滤系统提供的接口
 */
public class BSensitiveWordsFilter {
    public String filter(String text) {
        return "Bfilter-" + text;
    }
}
