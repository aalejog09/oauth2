package com.api.resources.config.oauth.properties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.security.cors")
public class CorsProperties {

    private String allowedOrigin;
    private String allowedMethod;
    private String maxAge;
    private String allowedHeader;

}
