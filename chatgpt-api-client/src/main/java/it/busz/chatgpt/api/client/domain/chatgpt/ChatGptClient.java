package it.busz.chatgpt.api.client.domain.chatgpt;

import it.busz.chatgpt.api.client.domain.chatgpt.external.ChatGptApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChatGptClient {
    private final ChatGptApi chatGptApi;

    public ChatGptClient(ChatGptApi chatGptApi) {
        this.chatGptApi = chatGptApi;
    }

    public String test(){
        final var models = chatGptApi.getModels();
        final var builder = new StringBuilder();
        for(final var model : models){
            builder.append(model.id());
        }
        return builder.toString();
    }
}
