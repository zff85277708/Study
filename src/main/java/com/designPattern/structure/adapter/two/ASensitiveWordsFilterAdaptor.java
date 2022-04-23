package com.designPattern.structure.adapter.two;

public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{
    private static final ASensitiveWordsFilter filter = new ASensitiveWordsFilter();

    @Override
    public String filter(String text) {
        String maskedText = filter.filterSexyWords(text);
        maskedText = filter.filterPoliticalWords(maskedText);
        return maskedText;
    }
}
