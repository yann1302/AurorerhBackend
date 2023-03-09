package com.advance.aurore_rh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.advance.aurore_rh"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(appInfo());
    }

    private ApiInfo appInfo(){
        return new ApiInfo(
                "AURORE RH",
                " api for Aurore RH",
                "1.0",
                "http://localhost/termsOfService",
                new springfox.documentation.service.Contact("DOKOULA yann","https://codesarray.com","yann.dokoula@2025.ucac-icam.com"),
                "abcd license",
                "http://abcdLicensing.com",
                Collections.emptyList()
        );
    }

}
