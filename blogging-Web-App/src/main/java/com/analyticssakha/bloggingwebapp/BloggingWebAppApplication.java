package com.analyticssakha.bloggingwebapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BloggingWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingWebAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelmapper(){
        return new ModelMapper();
    }

}
