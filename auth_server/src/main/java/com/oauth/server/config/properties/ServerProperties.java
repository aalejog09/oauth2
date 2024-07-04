package com.oauth.server.config.properties;


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
@ConfigurationProperties(prefix = "server")
public class ServerProperties {

    String serverUri;
    String port;
    String tokenUri;

    public String getOauthRq(){
        return this.serverUri.concat(":").concat(this.port).concat(this.tokenUri).concat("?");
    }


}
