package it.busz.chatgpt.api.client.domain.file.api;

import org.springframework.web.multipart.MultipartFile;

public record GptFileUploadRequest(
        MultipartFile file,
        String purpose
) {
}
