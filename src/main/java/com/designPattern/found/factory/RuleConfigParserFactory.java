package com.designPattern.found.factory;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactory {
//    public static IRuleConfigParser createParser(String configFormat) {
//        if (StringUtils.isBlank(configFormat)) return null;
//        IRuleConfigParser parser = null;
//
//        switch (configFormat) {
//            case "json":
//                parser = new JsonRuleConfigParser();
//                break;
//            case "xml":
//                parser = new XmlRuleConfigParser();
//                break;
//            case "yaml":
//                parser = new YamlRuleConfigParser();
//                break;
//            case "properties":
//                parser = new PropertiesRuleConfigParser();
//                break;
//        }
//        return parser;
//    }

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (StringUtils.isBlank(configFormat)) return null;
        return cachedParsers.get(configFormat.toLowerCase());
    }
}
