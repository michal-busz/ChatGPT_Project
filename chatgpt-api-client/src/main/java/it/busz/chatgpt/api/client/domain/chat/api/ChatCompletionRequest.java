package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatCompletionRequest(
        @NonNull
        List<Message> messages,
        String model,
        @Size(min = -2, max = 2)
        @JsonProperty("frequency_penalty")
        Float frequencyPenalty,
        @JsonProperty("logit_bias")
        JsonNode logitBias,
        @JsonProperty("max_tokens")
        Integer maxTokens,
        @JsonProperty("n")
        Integer quantity,
        @Size(min = -2, max = 2)
        @JsonProperty("presence_penalty")
        Float presencePenalty,
        @JsonProperty("response_format")
        ResponseFormat responseFormat,
        Integer seed,
        List<String> stop,
        Boolean stream,
        Float temperature,
        @JsonProperty("top_p")
        Float topP,
        List<Tool> tools,
        @JsonProperty("tool_choice")
        String toolChoice,
        String user

) {
    public static ChatCompletionRequest createMinimalRequest(List<Message> messages, String model) {
        return ChatCompletionRequest.builder()
                .messages(messages)
                .model(model)
                .build();
    }
}
