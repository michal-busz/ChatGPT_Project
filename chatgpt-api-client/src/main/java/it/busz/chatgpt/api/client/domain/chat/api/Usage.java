package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Usage(
        @JsonProperty("completion_tokens")
        Integer completionTokens,
        @JsonProperty("prompt_tokens")
        Integer promptTokens,
        @JsonProperty("total_tokens")
        Integer totalTokens
) {
}
