package it.busz.chatgpt.api.client.domain.file.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record GptFile(
        String id,
        Integer bytes,
        @JsonProperty("created_at")
        Instant createdAt,
        String filename,
        String object,
        String purpose
) {
}
