package it.busz.chatgpt.api.client.domain.model;

import it.busz.chatgpt.api.client.domain.model.api.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
class ModelServiceImpl implements ModelService {
    private final ModelClient modelClient;

    ModelServiceImpl(ModelClient modelClient) {
        this.modelClient = modelClient;
    }

    @Override
    public List<Model> getModels() {
        final var response = modelClient.getModels();
        return response.data();
    }

    @Override
    public Model getModel(String modelId) {
        return modelClient.getModel(modelId);
    }

    @Override
    public void deleteModel(String modelId) {
        modelClient.deleteModel(modelId);
        log.info("Successfully deleted model {}", modelId);
    }

}
