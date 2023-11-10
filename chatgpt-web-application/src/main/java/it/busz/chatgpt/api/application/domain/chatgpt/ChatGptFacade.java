package it.busz.chatgpt.api.application.domain.chatgpt;

import it.busz.chatgpt.api.client.domain.chatgpt.ChatGptClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatGptFacade {
    private final ChatGptClient chatGptClient;

    public ChatGptFacade(ChatGptClient chatGptClient) {
        this.chatGptClient = chatGptClient;
    }

    public String test(){
        return chatGptClient.test();
    }
}
