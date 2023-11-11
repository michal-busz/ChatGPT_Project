package it.busz.chatgpt.api.client.domain.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record Model(
        String id,
        String object,
        Instant created,
        @JsonProperty("owned_by")
        String ownedBy
) {
}
