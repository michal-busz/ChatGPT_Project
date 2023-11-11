package it.busz.chatgpt.api.client.domain.embedding;

import it.busz.chatgpt.api.client.domain.embedding.api.Embedding;
import it.busz.chatgpt.api.client.domain.embedding.api.EmbeddingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
class EmbeddingServiceImpl implements EmbeddingService {
    private final EmbeddingClient embeddingClient;

    EmbeddingServiceImpl(EmbeddingClient embeddingClient) {
        this.embeddingClient = embeddingClient;
    }

    @Override
    public List<Embedding> create(EmbeddingRequest request){
        return embeddingClient.create(request);
    }
}
