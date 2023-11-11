package it.busz.chatgpt.api.client.domain.chat;

import it.busz.chatgpt.api.client.domain.chat.api.ChatCompletionRequest;
import it.busz.chatgpt.api.client.domain.chat.api.Completion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class ChatServiceImpl implements  ChatService{
    private final ChatClient chatClient;

    ChatServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public Completion create(ChatCompletionRequest request){
        return chatClient.createCompletion(request);
    }
}
