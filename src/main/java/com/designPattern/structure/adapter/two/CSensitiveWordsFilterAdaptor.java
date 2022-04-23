package com.designPattern.structure.adapter.two;

public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{
    private static final CSensitiveWordsFilter filter = new CSensitiveWordsFilter();

    @Override
    public String filter(String text) {
        return filter.filter(text, "******");
    }
}
