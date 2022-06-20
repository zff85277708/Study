package com.designPattern.darklaunch.rule.parser;

import com.designPattern.darklaunch.rule.DarkRuleConfig;

import java.io.*;
import java.nio.file.Files;

public class JsonRuleConfigParser implements RuleConfigParser {
    @Override
    public DarkRuleConfig parse(String configText) throws IOException {
        InputStream in = Files.newInputStream(new File(configText).toPath());
        return parse(in);
    }

    @Override
    public DarkRuleConfig parse(InputStream in) {
        //TO DO
        return null;
    }
}
