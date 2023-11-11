package it.busz.chatgpt.api.client.domain.image.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ImageCreateRequest(
        String prompt,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String model,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("n")
        Integer quantity,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String quality,
        @JsonProperty("response_format")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String responseFormat,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String size,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String style,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String user
) {
}
