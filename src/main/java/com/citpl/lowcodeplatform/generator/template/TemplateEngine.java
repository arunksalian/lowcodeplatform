package com.citpl.lowcodeplatform.generator.template;

import com.citpl.lowcodeplatform.generator.model.AppConfig;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.FileTemplateLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

    public TemplateEngine() {
        handlebars = new Handlebars(new FileTemplateLoader("src/main/resources/templates", ".hbs"));
    
        // Register custom helper: capitalize
        handlebars.registerHelper("capitalize", (value, context) -> {
            if (value == null) return "";
            String str = value.toString();
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        });
    
        // Register custom helper: lowercase
        handlebars.registerHelper("lowercase", (value, context) -> {
            if (value == null) return "";
            return value.toString().toLowerCase();
        });
    }
    
    

   Handlebars handlebars = new Handlebars(new FileTemplateLoader("src/main/resources/templates", ".hbs"));
    private static final String TEMPLATE_PATH = "/templates/";

    // Generates code for entities based on the configuration
    public void generateCode(AppConfig config, String outputDir) throws IOException {
        // Ensure output directory exists
        File outputDirectory = new File(outputDir);
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        // Generate Java classes for entities
        for (AppConfig.Entity entity : config.getEntities()) {
            generateEntity(entity, config, outputDir);
            generateRepository(entity, config, outputDir);
            generateService(entity, config, outputDir);
            generateController(entity, config, outputDir);
        }
    }

    // Generate Java class for entity
    private void generateEntity(AppConfig.Entity entity, AppConfig config, String outputDir) throws IOException {
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("package", config.getPackageName());
        templateData.put("entity", entity);

        String templateName = "entity.java";
        Template template = handlebars.compile(templateName);
        String generatedCode = template.apply(templateData);

        writeFile(generatedCode, outputDir + "/models/" + entity.getName() + ".java");
    }

    // Generate repository for entity
    private void generateRepository(AppConfig.Entity entity, AppConfig config, String outputDir) throws IOException {
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("package", config.getPackageName());
        templateData.put("entity", entity);

        String templateName = "repository.java";
        Template template = handlebars.compile(templateName);
        String generatedCode = template.apply(templateData);

        writeFile(generatedCode, outputDir + "/repositories/" + entity.getName() + "Repository.java");
    }

    // Generate service for entity
    private void generateService(AppConfig.Entity entity, AppConfig config, String outputDir) throws IOException {
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("package", config.getPackageName());
        templateData.put("entity", entity);

        String templateName = "service.java";
        Template template = handlebars.compile(templateName);
        String generatedCode = template.apply(templateData);

        writeFile(generatedCode, outputDir + "/services/" + entity.getName() + "Service.java");
    }

    // Generate controller for entity
    private void generateController(AppConfig.Entity entity, AppConfig config, String outputDir) throws IOException {
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("package", config.getPackageName());
        templateData.put("entity", entity);

        String templateName = "controller.java";
        Template template = handlebars.compile(templateName);
        String generatedCode = template.apply(templateData);

        writeFile(generatedCode, outputDir + "/controllers/" + entity.getName() + "Controller.java");
    }

    // Write generated code to file
    // Write generated code to file
private void writeFile(String generatedCode, String filePath) throws IOException {
    File file = new File(filePath);
    File parentDir = file.getParentFile();

    if (!parentDir.exists()) {
        parentDir.mkdirs(); // Create missing parent folders like models/, repositories/, etc.
    }

    try (FileWriter fileWriter = new FileWriter(file)) {
        fileWriter.write(generatedCode);
    }
}

}
