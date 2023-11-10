package it.busz.chatgpt.api.client.domain.moderation;

import java.util.List;

record Moderation(
        String id,
        String model,
        List<ModerationResult> results
) {
}
