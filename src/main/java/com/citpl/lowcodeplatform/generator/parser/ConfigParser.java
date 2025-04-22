package com.citpl.lowcodeplatform.generator.parser;

import com.citpl.lowcodeplatform.generator.model.AppConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ConfigParser {

    // Parse YAML config file into AppConfig
    public static AppConfig parseConfig(File configFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(configFile, AppConfig.class);
    }
}
