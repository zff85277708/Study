package com.designPattern.ratelimiter.rule.parser;

import com.designPattern.ratelimiter.rule.RuleConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class JsonRuleConfigParser implements RuleConfigParser{
    @Override
    public RuleConfig parse(String configText) throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(configText));
        return parse(in);
    }

    @Override
    public RuleConfig parse(InputStream in) {
        //TO DO
        return null;
    }
}
