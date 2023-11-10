package it.busz.chatgpt.api.client.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

record Model(
        String id,
        String object,
        Instant created,
        @JsonProperty("owned_by")
        String ownedBy
) {
}
