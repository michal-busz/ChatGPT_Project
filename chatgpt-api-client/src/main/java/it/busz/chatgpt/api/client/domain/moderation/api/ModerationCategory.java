package it.busz.chatgpt.api.client.domain.moderation.api;

public record ModerationCategory(
        Boolean flagged,
        Double score
) {
}
