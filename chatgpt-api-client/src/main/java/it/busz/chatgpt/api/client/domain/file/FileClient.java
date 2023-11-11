package it.busz.chatgpt.api.client.domain.file;

import it.busz.chatgpt.api.client.domain.file.api.GptFile;
import it.busz.chatgpt.api.client.domain.file.api.GptFileUploadRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
class FileClient {
    private static final String FILES_ENDPOINT = "/files";
    private static final String SEPARATOR = "/";
    private static final String FILE_LABEL = "file";
    private static final String PURPOSE_LABEL = "purpose";
    private final RestTemplate restTemplate;
    private final String filesUrl;

    FileClient(RestTemplate restTemplate,
               @Value("${openapi.api.baseUrl}") String openApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.filesUrl = openApiBaseUrl + FILES_ENDPOINT;
    }

    List<GptFile> listFiles() {
        try {
            final var response = restTemplate.getForEntity(filesUrl, ListFilesResponse.class);
            final var files = Objects.requireNonNull(response.getBody());
            return files.data();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon getting files list", ex);
            throw ex;
        }
    }

    GptFile upload(GptFileUploadRequest request) {
        try {
            final var headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add(FILE_LABEL, request.file().getResource());
            body.add(PURPOSE_LABEL, request.purpose());

            final var requestEntity = new RequestEntity<>(body, headers, HttpMethod.POST, new URI(filesUrl));
            final var response = restTemplate.exchange(requestEntity, GptFile.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon uploading file {}", request.file().getOriginalFilename(), ex);
            throw ex;
        } catch (URISyntaxException e) {
            log.error("File upload URL is not a valid URI", e);
            return null;
        }
    }

    void delete(String fileId) {
        try {
            final var deleteUrl = filesUrl + SEPARATOR + fileId;
            restTemplate.delete(deleteUrl);
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon deleting file {}", fileId, ex);
            throw ex;
        }
    }

    GptFile retrieve(String fileId) {
        try {
            final var url = filesUrl + SEPARATOR + fileId;
            final var response = restTemplate.getForEntity(url, GptFile.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon retrieving file {}", fileId, ex);
            throw ex;
        }
    }

    String getJsonContent(String fileId) {
        try {
            final var url = filesUrl + SEPARATOR + fileId;
            final var response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon retrieving file JSON content {}", fileId, ex);
            throw ex;
        }
    }
}
