package com.oauth.server.config.properties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.stereotype.Component;

/**
 * Configuration Class for Security Parameters.
 * @author Developer
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.authorization.server.client.oidc-client.registration")
public class SecurityProperties {

    /**
     * Client-App Identification value for request this server
     */
    private String clientId;

    /**
     * Client-App Secret Code value for request this server
     */
    private String clientSecret;

    /**
     * Redirect URI for Authentication (if Authorization_Code is requested)
     */
    private String redirectUri;

    /**
     * Redirect URI for Logout.
     */
    private String postLogoutRedirectUri;

    /**
     * Type of AuthorizationGrantType Configured
     */
    private AuthorizationGrantType authorizationPassword;

    /**
     * Type of AuthorizationGrantType for token Request
     */
    private String authPassword;

    /**
     * Type of AuthorizationGrantType for token Refresh
     */
    private String authRefreshToken;

    /**
     * The time for Token Validity expressed in Seconds.
     */
    private Long tokenValiditySeconds;

    /**
     * The time for Token Validity expressed in Seconds.
     */
    private Long refreshTokenValiditySeconds;


}
