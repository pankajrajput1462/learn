package com.n26.tx.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * For swagger UI generation for Endpoint Testing. After starting the application you can test application by using
 * URl http://localhost:8080/swagger-ui.html
 *
 *
 * @author SINPANK
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo())
                .tags(new Tag("Transaction Statistics", "Statistics management"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Transaction Statistics").description("Transaction Statistics management").version("v1")
                .contact(new Contact("Pankaj Kumar", null, "pankajrajput08@yahoo.in")).build();
    }
}
