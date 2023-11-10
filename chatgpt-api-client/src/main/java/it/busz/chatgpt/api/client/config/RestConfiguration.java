package it.busz.chatgpt.api.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class RestConfiguration {
    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final String apiKey;

    RestConfiguration(@Value("${openapi.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        final var headerValue = BEARER_PREFIX + apiKey;
        return restTemplateBuilder
                .defaultHeader(AUTHORIZATION_HEADER_KEY, headerValue)
                .build();
    }
}
