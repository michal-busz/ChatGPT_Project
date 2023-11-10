package it.busz.chatgpt.api.client.domain.model;

import it.busz.chatgpt.api.client.domain.model.api.Model;

import java.util.List;

public interface ModelService {
    List<Model> getModels();

    Model getModel(String modelId);

    void deleteModel(String modelId);
}
