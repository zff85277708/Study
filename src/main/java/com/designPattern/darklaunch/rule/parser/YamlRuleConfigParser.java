package com.designPattern.darklaunch.rule.parser;

import com.designPattern.darklaunch.rule.DarkRuleConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;

public class YamlRuleConfigParser implements RuleConfigParser {
    @Override
    public DarkRuleConfig parse(String configText) throws IOException {
        InputStream in = Files.newInputStream(new File(configText).toPath());
        return parse(in);
    }

    @Override
    public DarkRuleConfig parse(InputStream in) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(in, DarkRuleConfig.class);
    }
}
