package com.cityinfoapp.cityinfoservice.config;


import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
@NoArgsConstructor
public class SwaggerConfiguration {

    @Bean
    public Docket getSwaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cityinfoapp.cityinfoservice"))
                .build()
				.apiInfo(apiDetails());
    }

    private ApiInfo apiDetails () {
        return new ApiInfo(
                "City info API",
                "Get weather data for a selected city and information about its country.",
                "1.0",
                "Only for authorized users.",
                new springfox.documentation.service.Contact("Damian", null, "damian.gorka94@gmail.com"),
                "API License",
                "www.null.com",
                Collections.emptyList());
    }
}
