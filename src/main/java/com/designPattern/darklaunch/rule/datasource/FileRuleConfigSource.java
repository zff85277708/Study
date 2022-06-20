package com.designPattern.darklaunch.rule.datasource;

import com.designPattern.darklaunch.DarkFeature;
import com.designPattern.darklaunch.rule.DarkRuleConfig;
import com.designPattern.darklaunch.IDarkFeature;
import com.designPattern.darklaunch.rule.parser.JsonRuleConfigParser;
import com.designPattern.darklaunch.rule.parser.RuleConfigParser;
import com.designPattern.darklaunch.rule.parser.YamlRuleConfigParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FileRuleConfigSource implements RuleConfigSource {
    private static final Logger log = LoggerFactory.getLogger(FileRuleConfigSource.class);
    private static final String API_DARK_CONFIG_NAME = "dark-rule";
    private static final String YAML_EXTENSION = "yaml";
    private static final String YML_EXTENSION = "yml";
    private static final String JSON_EXTENSION = "json";
    private static final String[] SUPPORT_EXTENSIONS =
            new String[] {JSON_EXTENSION, YML_EXTENSION, YAML_EXTENSION};
    private static final Map<String, RuleConfigParser> PARSER_MAP = new HashMap<>();
    private static final FileRuleConfigSource FILE_RULE_CONFIG_SOURCE= new FileRuleConfigSource();

    static {
        PARSER_MAP.put(YAML_EXTENSION, new YamlRuleConfigParser());
        PARSER_MAP.put(YML_EXTENSION, new YamlRuleConfigParser());
        PARSER_MAP.put(JSON_EXTENSION, new JsonRuleConfigParser());
    }

    private FileRuleConfigSource(){}

    public static FileRuleConfigSource getInstance() {
        return FILE_RULE_CONFIG_SOURCE;
    }

    @Override
    public Map<String, IDarkFeature> loadRule() {
        //将灰度规则配置文件dark-rule.xxx中的内容读取到DarkRuleConfig中
        for (String extension : SUPPORT_EXTENSIONS) {
            log.info("loadRule from /dark-rule.yaml");
            DarkRuleConfig ruleConfig = null;
            try (InputStream in = this.getClass().getResourceAsStream("/" + getFileNameByExt(extension))){
                if (in == null) continue;
                RuleConfigParser parser = PARSER_MAP.get(extension);
                ruleConfig = parser.parse(in);
            } catch (IOException e) {
                log.error("close file error:{}", e);
            }

            assert ruleConfig != null;

            //单独更新从配置文件中得到的灰度规则，不覆盖编程实现的灰度规则
            Map<String, IDarkFeature> darkFeatures = new HashMap<>();
            for (DarkRuleConfig.DarkFeatureConfig darkFeatureConfig : ruleConfig.getFeatures()) {
                darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
            }
            return darkFeatures;
        }
        return null;
    }

    private String getFileNameByExt(String extension) {
        return API_DARK_CONFIG_NAME + "." + extension;
    }
}
