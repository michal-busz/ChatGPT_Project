package it.busz.chatgpt.api.client.domain.moderation.api;

public record ModerationRequest(
        String input,
        String model
) {
}
