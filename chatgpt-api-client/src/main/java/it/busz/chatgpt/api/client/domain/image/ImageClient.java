package it.busz.chatgpt.api.client.domain.image;

import it.busz.chatgpt.api.client.domain.image.api.Image;
import it.busz.chatgpt.api.client.domain.image.api.ImageCreateRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageEditRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageVariationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
class ImageClient {
    private static final String IMAGES_API = "/images";
    private static final String GENERATIONS_ENDPOINT = "/generations";
    private static final String EDITS_ENDPOINT = "/edits";
    private static final String VARIATIONS_ENDPOINT = "/variations";
    private final RestTemplate restTemplate;
    private final String generationsUrl;
    private final String editsUrl;
    private final String variationsUrl;

    public ImageClient(RestTemplate restTemplate,
                       @Value("${openapi.api.baseUrl}") String openApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.editsUrl = openApiBaseUrl + IMAGES_API + EDITS_ENDPOINT;
        this.generationsUrl = openApiBaseUrl + IMAGES_API + GENERATIONS_ENDPOINT;
        this.variationsUrl = openApiBaseUrl + IMAGES_API + VARIATIONS_ENDPOINT;
    }

    List<Image> create(ImageCreateRequest request) {
        try {
            final var response = restTemplate.postForEntity(generationsUrl, request, ImageResponse.class);
            return getImagesFrom(response);
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon generating image", ex);
            throw ex;
        }
    }

    List<Image> edit(ImageEditRequest request) {
        try {
            final var headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", request.image().getResource());
            body.add("prompt", "funny");
            body.add("mask", request.mask().getResource());

            final var requestEntity = new RequestEntity<>(body, headers, HttpMethod.POST, new URI(editsUrl));
            final var response = restTemplate.exchange(requestEntity, ImageResponse.class);
            return getImagesFrom(response);
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon editing image", ex);
            throw ex;
        } catch (URISyntaxException e) {
            log.error("Image edit URL is not a valid URI", e);
            return Collections.emptyList();
        }
    }

    List<Image> variation(ImageVariationRequest request) {
        try {
            final var headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", request.image().getResource());

            final var requestEntity = new RequestEntity<>(body, headers, HttpMethod.POST, new URI(variationsUrl));
            final var response = restTemplate.exchange(requestEntity, ImageResponse.class);
            return getImagesFrom(response);
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon variation image", ex);
            throw ex;
        } catch (URISyntaxException e) {
            log.error("Image variation URL is not a valid URI", e);
            return Collections.emptyList();
        }
    }

    private List<Image> getImagesFrom(ResponseEntity<ImageResponse> response) {
        final var body = Objects.requireNonNull(response.getBody());
        return body.data();
    }

}
