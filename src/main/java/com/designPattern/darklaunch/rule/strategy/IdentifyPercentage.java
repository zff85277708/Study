package com.designPattern.darklaunch.rule.strategy;

import lombok.Getter;

@Getter
public class IdentifyPercentage implements IdentifyRule{
    private int percentage;

    @Override
    public void identify(String darkRule) {
        int newPercentage = Integer.parseInt(darkRule.substring(0, darkRule.length() - 1));
        if (newPercentage > percentage)
            percentage = newPercentage;
    }
}
