package com.designPattern.found.factory.method;

public class PropertiesRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig("properties");
    }
}
