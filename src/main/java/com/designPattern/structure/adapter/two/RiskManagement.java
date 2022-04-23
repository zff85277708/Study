package com.designPattern.structure.adapter.two;

import java.util.ArrayList;
import java.util.List;

public class RiskManagement {
    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String text) {
        String maskedText = text;
        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }

    public static void main(String[] args) {
        RiskManagement management = new RiskManagement();
        management.addSensitiveWordsFilter(new ASensitiveWordsFilterAdaptor());
        management.addSensitiveWordsFilter(new BSensitiveWordsFilterAdaptor());
        management.addSensitiveWordsFilter(new CSensitiveWordsFilterAdaptor());
        System.out.println(management.filterSensitiveWords("Hello"));
    }
}
