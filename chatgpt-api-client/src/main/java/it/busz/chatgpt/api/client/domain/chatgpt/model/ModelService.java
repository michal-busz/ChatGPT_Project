package it.busz.chatgpt.api.client.domain.chatgpt.model;

import it.busz.chatgpt.api.client.domain.chatgpt.api.ModelDto;

import java.util.Collection;

public interface ModelService {
    Collection<ModelDto> getModels();
}
