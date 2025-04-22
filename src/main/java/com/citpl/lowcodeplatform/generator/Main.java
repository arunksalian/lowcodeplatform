package com.citpl.lowcodeplatform.generator;

import com.citpl.lowcodeplatform.generator.model.AppConfig;
import com.citpl.lowcodeplatform.generator.template.TemplateEngine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Load the configuration (this can be a file or other sources)
        AppConfig config = loadConfig();

        // Create an instance of TemplateEngine
        TemplateEngine templateEngine = new TemplateEngine();

        try {
            // Generate the CRUD application code
            String outputDir = "generated-code";  // Directory where the generated code will be saved
            templateEngine.generateCode(config, outputDir);
            System.out.println("Code generation successful!");
        } catch (IOException e) {
            System.err.println("Error during code generation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static AppConfig loadConfig() {
        // This method should load your configuration (e.g., from a JSON or YAML file)
        // For simplicity, we'll create a basic configuration object here
        AppConfig config = new AppConfig();
        config.setPackageName("com.citpl.lowcodeplatform");

        // Define an entity with some fields
        AppConfig.Entity entity = new AppConfig.Entity();
        entity.setName("User");
        entity.addField("Long", "id");
        entity.addField("String", "name");
        entity.addField("String", "email");

        config.addEntity(entity);
        return config;
    }
}
