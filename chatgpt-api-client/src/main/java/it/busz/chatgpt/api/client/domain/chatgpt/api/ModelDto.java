package it.busz.chatgpt.api.client.domain.chatgpt.api;

import java.time.Instant;

public record ModelDto(
        String id,
        String object,
        Instant created,
        String ownedBy
) {
}
