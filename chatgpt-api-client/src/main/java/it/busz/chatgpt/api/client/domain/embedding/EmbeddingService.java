package it.busz.chatgpt.api.client.domain.embedding;

import it.busz.chatgpt.api.client.domain.embedding.api.Embedding;
import it.busz.chatgpt.api.client.domain.embedding.api.EmbeddingRequest;

import java.util.List;

public interface EmbeddingService {
    List<Embedding> create(EmbeddingRequest request);
}
