package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ResponseFormat {
    @JsonProperty("text")
    TEXT,
    @JsonProperty("json_object")
    JSON
}
