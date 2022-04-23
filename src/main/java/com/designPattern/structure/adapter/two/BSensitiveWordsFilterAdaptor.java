package com.designPattern.structure.adapter.two;

public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{
    private static final BSensitiveWordsFilter filter = new BSensitiveWordsFilter();

    @Override
    public String filter(String text) {
        return filter.filter(text);
    }
}
