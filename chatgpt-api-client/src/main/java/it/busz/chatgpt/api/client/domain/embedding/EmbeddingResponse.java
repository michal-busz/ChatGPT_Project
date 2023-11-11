package it.busz.chatgpt.api.client.domain.embedding;

import it.busz.chatgpt.api.client.domain.embedding.api.Embedding;

import java.util.List;

record EmbeddingResponse(
        String object,
        List<Embedding> data
) {
}
