package it.busz.chatgpt.api.client.domain.moderation;

import it.busz.chatgpt.api.client.domain.moderation.api.ModerationModel;
import it.busz.chatgpt.api.client.domain.moderation.api.ModerationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
class ModerationClient {
    private static final String MODERATION_ENDPOINT = "/moderations";
    private final RestTemplate restTemplate;
    private final String moderationUrl;

    ModerationClient(RestTemplate restTemplate,
                     @Value("${openapi.api.baseUrl}")String openApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.moderationUrl = openApiBaseUrl + MODERATION_ENDPOINT;
    }

    Moderation createModeration(ModerationRequest request){
        try{
            final var response = restTemplate.postForEntity(moderationUrl, request, Moderation.class);
            return response.getBody();
        } catch(HttpClientErrorException ex){
            log.error("HTTP client exception thrown upon getting moderation", ex);
            throw ex;
        }
    }
}
