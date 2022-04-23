package com.designPattern.structure.adapter.two;

/**
 * A敏感词过滤系统提供的接口
 */
public class ASensitiveWordsFilter {
    public String filterSexyWords(String text) {
        return "filterSexyWords-" + text;
    }

    public String filterPoliticalWords(String text) {
        return "filterPoliticalWords-" + text;
    }
}
