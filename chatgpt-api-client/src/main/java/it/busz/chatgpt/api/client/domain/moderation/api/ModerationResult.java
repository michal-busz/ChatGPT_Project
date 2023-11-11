package it.busz.chatgpt.api.client.domain.moderation.api;

public record ModerationResult(
        Boolean flagged,
        ModerationCategories categories
) {
}
