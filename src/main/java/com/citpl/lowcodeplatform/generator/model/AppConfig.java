package com.citpl.lowcodeplatform.generator.model;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {

    private String packageName;
    private List<Entity> entities = new ArrayList<>();

    // Getters and Setters
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    // Entity Class
    public static class Entity {
        private String name;
        private List<Field> fields = new ArrayList<>();

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Field> getFields() {
            return fields;
        }

        // Add a field to the entity
        public void addField(String type, String name) {
            this.fields.add(new Field(type, name));
        }
    }

    // Field Class
    public static class Field {
        private String type;
        private String name;

        public Field(String type, String name) {
            this.type = type;
            this.name = name;
        }

        // Getters and Setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
