package it.busz.chatgpt.api.client.domain.moderation.api;

import java.util.List;

public record Moderation(
        String id,
        String model,
        List<ModerationResult> results
) {
}
