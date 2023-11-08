package it.busz.chatgpt.api.client.domain.chatgpt.external;

import it.busz.chatgpt.api.client.domain.chatgpt.api.ModelDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
class ChatGptApiClient implements ChatGptApi {
    private static final String MODELS_ENDPOINT = "/models";
    private final String openApiBaseUrl;
    private final RestTemplate restTemplate;

    ChatGptApiClient(@Value("${openapi.api.baseUrl}") String openApiBaseUrl,
                     RestTemplate restTemplate) {
        this.openApiBaseUrl = openApiBaseUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public Collection<ModelDto> getModels() {
        final var url = openApiBaseUrl + MODELS_ENDPOINT;
        try {
            final var response = restTemplate.getForEntity(url, ModelResponse.class);
            final var models = response.getBody();
            return mapModels(models);
        } catch (HttpClientErrorException ex) {
            log.error("Error while fetching response", ex);
        }
        return Collections.emptyList();
    }

    private List<ModelDto> mapModels(ModelResponse response) {
        final var result = new ArrayList<ModelDto>();
        final var models = response.data();
        for (var model : models) {
            final var dto = new ModelDto(model.id(), model.object(), model.created(), model.ownedBy());
            result.add(dto);
        }
        return result;
    }
}
