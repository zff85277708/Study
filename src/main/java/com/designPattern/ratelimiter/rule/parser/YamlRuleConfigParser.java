package com.designPattern.ratelimiter.rule.parser;

import com.designPattern.ratelimiter.rule.RuleConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class YamlRuleConfigParser implements RuleConfigParser{
    @Override
    public RuleConfig parse(String configText) throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(configText));
        return parse(in);
    }

    @Override
    public RuleConfig parse(InputStream in) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(in, RuleConfig.class);
    }
}
