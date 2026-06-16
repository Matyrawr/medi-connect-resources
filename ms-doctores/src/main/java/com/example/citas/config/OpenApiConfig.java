package com.example.citas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI doctorsApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio de Doctores")
                        .version("v1")
                        .description("API REST para registrar, listar y consultar doctores"));
    }
}