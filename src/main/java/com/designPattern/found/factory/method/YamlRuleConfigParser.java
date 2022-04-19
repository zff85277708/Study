package com.designPattern.found.factory.method;

public class YamlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig("yaml");
    }
}
