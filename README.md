# Low Code CRUD Generator

A Spring Boot-based low-code platform that generates CRUD (Create, Read, Update, Delete) applications from YAML configurations.

## Features

- Generate complete Spring Boot CRUD applications from YAML configurations
- Automated generation of:
  - Controllers
  - Services
  - Repositories
  - Entity models
- Handlebars templating for code generation
- Swagger/OpenAPI documentation support
- REST API endpoints for configuration upload

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Tech Stack

- Spring Boot 3.2.5
- Handlebars 4.3.1
- Jackson YAML Parser
- SpringDoc OpenAPI UI

## Project Structure

```
lowcodeplatform/
├── src/main/
│   ├── java/com/citpl/lowcodeplatform/
│   │   ├── config/          # Configuration classes
│   │   ├── generator/       # Code generation logic
│   │   │   ├── controller/  # Web controllers
│   │   │   ├── model/       # Data models
│   │   │   ├── parser/      # YAML parsing
│   │   │   └── template/    # Template engine
│   └── resources/
│       ├── templates/       # Handlebars templates
│       └── application.properties
└── generated-code/          # Output directory for generated code
```

## Building

```bash
mvn clean install
```

## Running

```bash
mvn spring-boot:run
```

## Usage

1. Prepare your YAML configuration file describing the desired entities and their relationships
2. Use either:
   - REST API endpoint to upload configuration
   - Direct file input through the application
3. Generated code will be available in the `generated-code` directory

## License

Proprietary - Copyright © 2024 CITPL
