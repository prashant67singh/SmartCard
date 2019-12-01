package com.noobcoders.smartcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Contact contactInfo = new Contact("NoobCoders", "http://www.google.com", "NoobCoders@gmail.com");
    private static final ApiInfo API_INFO = new ApiInfo(
            "Smart Card Bengalore",
            "Rest API for Smart Card Bengalore Related Operations",
            "1.0",
            "urn:tos",
            contactInfo,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<>());
    private static final Set<String> produces = new HashSet<>(
            Arrays.asList(
                    "application/json"
            )
    );
    private static final Set<String> consumes = new HashSet<>(
            Arrays.asList(
                    "application/json"
            )
    );

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .produces(produces)
                .consumes(consumes);
    }
}
