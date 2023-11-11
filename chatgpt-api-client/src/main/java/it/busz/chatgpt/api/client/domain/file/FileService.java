package it.busz.chatgpt.api.client.domain.file;

import it.busz.chatgpt.api.client.domain.file.api.GptFile;
import it.busz.chatgpt.api.client.domain.file.api.GptFileUploadRequest;

import java.util.List;

public interface FileService {
    List<GptFile> listFiles();

    GptFile upload(GptFileUploadRequest request);

    void delete(String fileId);

    GptFile retrieve(String fileId);

    String getJsonContent(String fileId);
}
