package it.busz.chatgpt.api.client.domain.embedding;

import it.busz.chatgpt.api.client.domain.embedding.api.Embedding;
import it.busz.chatgpt.api.client.domain.embedding.api.EmbeddingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
class EmbeddingClient {
    private static final String EMBEDDINGS_ENDPOINT = "/embeddings";
    private final RestTemplate restTemplate;
    private final String embeddingsUrl;

    EmbeddingClient(RestTemplate restTemplate,
                    @Value("${openapi.api.baseUrl}") String openApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.embeddingsUrl = openApiBaseUrl + EMBEDDINGS_ENDPOINT;
    }

    List<Embedding> create(EmbeddingRequest request){
        try{
            final var response = restTemplate.postForEntity(embeddingsUrl, request, EmbeddingResponse.class);
            final var embeddings = Objects.requireNonNull(response.getBody());
            return embeddings.data();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon creating embedding {}", request, ex);
            throw ex;
        }
    }
}
