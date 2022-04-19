package com.designPattern.found.factory.method;

public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (null == parserFactory)
            throw new InvalidRuleConfigException(
                    "Rule config file format is not supported:" + ruleConfigFilePath);

        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        String[] parts = filePath.split("\\.");
        return parts[parts.length - 1];
    }

    public static void main(String[] args) {
        RuleConfig ruleConfig = new RuleConfigSource().load("application.properties");
        System.out.println(ruleConfig.show());
    }
}