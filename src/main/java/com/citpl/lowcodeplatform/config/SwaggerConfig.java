package com.citpl.lowcodeplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public Info customInfo() {
        return new Info()
                .title("Low Code Platform API")
                .version("1.0.0")
                .description("API documentation for Low Code Platform CRUD Generator")
                .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"));
    }
}
