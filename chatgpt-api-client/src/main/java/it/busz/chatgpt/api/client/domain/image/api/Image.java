package it.busz.chatgpt.api.client.domain.image.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public record Image(
        @JsonProperty("b64_json")
        String json,
        URI url,
        @JsonProperty("revised_prompt")
        String revisedPrompt

) {
}
