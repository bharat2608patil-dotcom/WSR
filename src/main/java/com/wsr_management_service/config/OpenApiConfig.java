package com.wsr_management_service.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("WSR Management System")
                                .version("1.0")
                                .description(
                                        "Weekly Status Report Management APIs")
                );
    }
}