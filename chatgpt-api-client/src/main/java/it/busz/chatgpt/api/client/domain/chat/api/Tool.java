package it.busz.chatgpt.api.client.domain.chat.api;

public record Tool(
        String type,
        ToolFunction function
) {
}
