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
    private static final String SEPARATOR = "/";
    private final RestTemplate restTemplate;
    private final String modelsUrl;

    public ModelClient(RestTemplate restTemplate,
                       @Value("${openapi.api.baseUrl}") String openApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.modelsUrl = openApiBaseUrl + MODELS_ENDPOINT;
    }

    ModelResponse getModels() {
        try {
            final var response = restTemplate.getForEntity(modelsUrl, ModelResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon getting models", ex);
            throw ex;
        }
    }

    Model getModel(String modelId){
        final var url = modelsUrl + SEPARATOR + modelId;
        try{
            final var response = restTemplate.getForEntity(url, Model.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon getting model", ex);
            throw ex;
        }
    }

    void deleteModel(String modelId){
        final var url = modelsUrl + SEPARATOR + modelId;
        try{
            restTemplate.delete(url);
        } catch(HttpClientErrorException ex){
            log.error("HTTP client exception thrown upon deleting model", ex);
            throw ex;
        }
    }
}
