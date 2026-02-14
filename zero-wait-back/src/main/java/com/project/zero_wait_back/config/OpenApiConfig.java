package com.project.zero_wait_back.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {

    @Bean
    public OpenAPI openAPIConfig() {
        OpenAPI openAPI = new OpenAPI();

        Info info = new Info();
        info.title("zero-wait project swagger");
        info.version("1.0");
        info.description("기능 시험중");
//
//        SecurityRequirement securityRequirement = new SecurityRequirement();
//        securityRequirement.addList("Bearer Authentication");
//
//        SecurityScheme securityScheme = new SecurityScheme();
//        securityScheme.name("Bearer Authentication");
//        securityScheme.type(SecurityScheme.Type.HTTP);
//        securityScheme.scheme("bearer");
//        securityScheme.bearerFormat("JWT");
//
//        Components components = new Components();
//        components.addSecuritySchemes("Bearer Authentication", securityScheme);

        return openAPI
                .info(info);
//                .addSecurityItem(securityRequirement)
//                .components(components);
    }

}
