package it.busz.chatgpt.api.client.domain.chat;

import it.busz.chatgpt.api.client.domain.chat.api.ChatCompletionRequest;
import it.busz.chatgpt.api.client.domain.chat.api.Completion;

public interface ChatService {
    Completion create(ChatCompletionRequest request);
}
