package it.busz.chatgpt.api.client.domain.model;

import it.busz.chatgpt.api.client.domain.model.api.ModelDto;

import java.util.Collection;

public interface ModelService {
    Collection<ModelDto> getModels();
    ModelDto getModel(String modelId);
    void deleteModel(String modelId);
}
