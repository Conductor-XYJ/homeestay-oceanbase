package com.ustb.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map /uploaded/** to the local uploaded directory
        // file:./uploaded/ means a folder named 'uploaded' in the project root
        registry.addResourceHandler("/uploaded/**")
                .addResourceLocations("file:./uploaded/");
    }
}
