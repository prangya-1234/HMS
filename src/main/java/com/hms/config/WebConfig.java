package com.hms.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","http://localhost:3001","http://localhost:3002")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
         // You can also specify allowed headers, exposed headers, etc.=
    }
}