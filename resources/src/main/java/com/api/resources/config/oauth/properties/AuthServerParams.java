package com.api.resources.config.oauth.properties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.auth-server")
public class AuthServerParams {

    private String baseUri;



}
