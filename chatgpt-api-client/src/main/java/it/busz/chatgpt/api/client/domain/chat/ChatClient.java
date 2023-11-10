package it.busz.chatgpt.api.client.domain.chat;

import it.busz.chatgpt.api.client.domain.chat.api.ChatCompletionRequest;
import it.busz.chatgpt.api.client.domain.chat.api.Completion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
class ChatClient {
    private static final String COMPLETIONS_ENDPOINT = "/chat/completions";
    private final RestTemplate restTemplate;
    private final String completionsUrl;

    ChatClient(RestTemplate restTemplate,
               @Value("${openapi.api.baseUrl}") String openApiBaseUrl) {
        this.restTemplate = restTemplate;
        this.completionsUrl = openApiBaseUrl + COMPLETIONS_ENDPOINT;
    }

    Completion createCompletion(ChatCompletionRequest request) {
        try {
            final var response = restTemplate.postForEntity(completionsUrl, request, Completion.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("HTTP client exception thrown upon getting chat completion", ex);
            throw ex;
        }
    }


}
