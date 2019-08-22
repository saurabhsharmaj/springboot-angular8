package com.sample.im.config;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 
                .apis(RequestHandlerSelectors.basePackage("com.sample.im.controller"))
//                .paths(regex("HomeController"))
                .build()
                .pathMapping("/");
    }
    
    private ApiInfo metaData() {
        Collection<VendorExtension> emailList = new ArrayList<VendorExtension>();
        VendorExtension email = new StringVendorExtension("email", "saurabh.find@gmail.com") ;
		emailList.add(email );
		ApiInfo apiInfo = new ApiInfo(
                "REST API",
                "REST API for IM",
                "1.0",
                "Terms of service",
                new Contact("Saurabh Sharma", "---", "saurbhsharmaj"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", emailList );
        return apiInfo;
    }
}