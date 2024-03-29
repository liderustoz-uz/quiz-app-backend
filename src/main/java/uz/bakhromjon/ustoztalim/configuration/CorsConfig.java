package uz.bakhromjon.ustoztalim.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowCredentials(true).
                allowedOrigins("https://liderustoz.uz", "http://localhost:3000", "http://localhost:80", "http://161.35.70.130", "https://qvc-test-website.netlify.app").
                allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH").
                allowedHeaders("*");
    }
}

