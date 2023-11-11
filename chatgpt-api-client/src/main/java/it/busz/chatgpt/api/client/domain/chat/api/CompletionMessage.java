package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CompletionMessage(
        String content,
        @JsonProperty("tool_calls")
        List<ToolCall> toolCalls,
        String role

) {
}
