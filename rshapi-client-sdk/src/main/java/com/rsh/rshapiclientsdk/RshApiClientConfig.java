package com.rsh.rshapiclientsdk;

import com.rsh.rshapiclientsdk.client.RshApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author rsh
 * @date 2023/3/10 15:23
 */
@Configuration
@ConfigurationProperties("rshapi.client")
@Data
@ComponentScan
public class RshApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public RshApiClient rshApiClient(){
        return new RshApiClient(accessKey,secretKey);
    }
}
