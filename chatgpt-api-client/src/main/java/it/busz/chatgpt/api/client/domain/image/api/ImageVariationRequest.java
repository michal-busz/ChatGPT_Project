package it.busz.chatgpt.api.client.domain.image.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record ImageVariationRequest(
        MultipartFile image,
        String model,
        @JsonProperty("n")
        Integer quantity,
        @JsonProperty("response_format")
        String responseFormat,
        String size,
        String user
) {
}
