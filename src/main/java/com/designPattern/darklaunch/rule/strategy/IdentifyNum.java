package com.designPattern.darklaunch.rule.strategy;

import com.google.common.collect.Range;
import lombok.Getter;

@Getter
public class IdentifyNum implements IdentifyRule{
    private Range<Long> range;

    @Override
    public void identify(String darkRule) {
        long val = Long.parseLong(darkRule);
        range = Range.closed(val, val);
    }
}
