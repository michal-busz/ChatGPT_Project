package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class CompletionChunk {
    private String id;
    private List<CompletionChoices> choices;
    private Instant created;
    private String model;
    @JsonProperty("system_fingerprint")
    private String systemFingerprint;
    private String object;
}
