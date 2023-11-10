package it.busz.chatgpt.api.client.domain.moderation.api;

public record ModerationCategories(
        ModerationCategory sexual,
        ModerationCategory hate,
        ModerationCategory harassment,
        ModerationCategory selfHarm,
        ModerationCategory sexualMinors,
        ModerationCategory hateThreatening,
        ModerationCategory violenceGraphic,
        ModerationCategory selfHarmIntent,
        ModerationCategory selfHarmInstructions,
        ModerationCategory harassmentThreatening,
        ModerationCategory violence
) {
}
