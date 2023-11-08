package it.busz.chatgpt.api.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class RestConfiguration {
    @Value("${openapi.api.key}")
    private String apiKey;

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder
                .defaultHeader(AUTHORIZATION_HEADER_KEY, BEARER_PREFIX + apiKey)
                .build();
    }
}
