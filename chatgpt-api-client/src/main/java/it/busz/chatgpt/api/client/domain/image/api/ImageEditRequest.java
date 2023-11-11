package it.busz.chatgpt.api.client.domain.image.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record ImageEditRequest(
        MultipartFile image,
        String prompt,
        MultipartFile mask,
        String model,
        @JsonProperty("n")
        Integer quantity,
        String size,
        @JsonProperty("response_format")
        String responseFormat,
        String user
) {
}
