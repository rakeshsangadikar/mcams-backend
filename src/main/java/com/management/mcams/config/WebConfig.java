package com.management.mcams.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // allow CORS for all endpoints
                .allowedOrigins("http://localhost:5173") // change if your frontend runs on another origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Static resource handler (optional if needed)
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}

