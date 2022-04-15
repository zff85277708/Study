package com.designPattern.found.factory;

public class YamlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig("yaml");
    }
}
