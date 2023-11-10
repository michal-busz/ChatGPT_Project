package it.busz.chatgpt.api.client.domain.chat.api;

public record ToolCall(
        String id,
        String type,
        ToolFunction function
) {
}
