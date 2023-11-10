package it.busz.chatgpt.api.client.domain.chatgpt.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
class ModelClient {
    private static final String MODELS_ENDPOINT = "/models";
    private final RestTemplate restTemplate;
    private final String openApiBaseUrl;

    public ModelClient(RestTemplate restTemplate,
                       @Value("${openapi.api.baseUrl}") String openApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.openApiBaseUrl = openApiBaseUrl;
    }

    ModelResponse getModels() {
        final var url = openApiBaseUrl + MODELS_ENDPOINT;
        try {
            final var response = restTemplate.getForEntity(url, ModelResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("Client exception thrown upon getting models", ex);
            throw ex;
        }
    }


}
