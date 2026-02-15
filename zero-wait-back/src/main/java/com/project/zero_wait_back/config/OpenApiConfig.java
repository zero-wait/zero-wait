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

        return openAPI
                .info(info);
    }

}
