package com.omeerdvrn.webclienttest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient getWebClient(@Value("${API_URI}") String apiURI){
        return WebClient.builder().baseUrl(apiURI).build();
    }
}
