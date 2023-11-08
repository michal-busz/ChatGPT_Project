package it.busz.chatgpt.api.client.domain.chatgpt.external;

import it.busz.chatgpt.api.client.domain.chatgpt.api.ModelDto;

import java.util.Collection;

public interface ChatGptApi {
    Collection<ModelDto>  getModels();
}
