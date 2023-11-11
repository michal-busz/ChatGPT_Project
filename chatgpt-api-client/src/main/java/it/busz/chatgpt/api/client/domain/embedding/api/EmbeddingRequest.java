package it.busz.chatgpt.api.client.domain.embedding.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record EmbeddingRequest(
        @NonNull
        String input,
        @NonNull
        String model,
        @JsonProperty("encoding_format")
        String encodingFormat,
        String user
) {
}
