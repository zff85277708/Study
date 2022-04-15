package com.designPattern.found.factory;

public class XmlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig("xml");
    }
}
