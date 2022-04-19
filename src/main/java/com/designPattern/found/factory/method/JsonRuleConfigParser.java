package com.designPattern.found.factory.method;

public class JsonRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig("json");
    }
}
