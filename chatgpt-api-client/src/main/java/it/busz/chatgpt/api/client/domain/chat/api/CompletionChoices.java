package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompletionChoices(
        @JsonProperty("finish_reason")
        String finishReason,
        Integer index,
        CompletionMessage message
) {
}
