package com.designPattern.found.factory.method;

public class XmlRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig("xml");
    }
}
