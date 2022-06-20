package com.designPattern.darklaunch.rule.strategy;

import com.google.common.collect.Range;
import lombok.Getter;

@Getter
public class IdentifyRange implements IdentifyRule{
    private Range<Long> range;

    @Override
    public void identify(String darkRule) {
        String[] parts = darkRule.split("-");
        if (parts.length != 2)
            throw new RuntimeException("Failed to parse dark rule: " + darkRule);
        long start = Long.parseLong(parts[0]);
        long end = Long.parseLong(parts[1]);
        if (start > end)
            throw new RuntimeException("Failed to parse dark rule: " + darkRule);
        range = Range.closed(start, end);
    }
}
