package it.busz.chatgpt.api.client.domain.embedding.api;

import java.util.List;

public record Embedding(
        Integer index,
        List<Float> embedding,
        String object
) {
}
