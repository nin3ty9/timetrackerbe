package com.timetrackerbe.timetrackerbe.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    //Cors som globalt tillåter alla anrop från enbart timetrackerfe på DigitalOcean:
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://lobster-app-gnq4y.ondigitalocean.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
