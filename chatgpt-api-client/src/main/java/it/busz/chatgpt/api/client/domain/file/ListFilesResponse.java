package it.busz.chatgpt.api.client.domain.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.busz.chatgpt.api.client.domain.file.api.GptFile;

import java.util.List;

record ListFilesResponse(
        String object,
        @JsonProperty("has_more")
        Boolean hasMore,
        List<GptFile> data
) {
}
