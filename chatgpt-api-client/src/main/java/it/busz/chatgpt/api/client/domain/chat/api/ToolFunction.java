package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolFunction(
        @NonNull
        String name,
        String arguments, //Response part
        String parameters, //Request part
        String description //Request part
) {
}
