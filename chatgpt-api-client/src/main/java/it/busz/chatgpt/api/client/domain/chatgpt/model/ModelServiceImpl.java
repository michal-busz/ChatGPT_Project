package it.busz.chatgpt.api.client.domain.chatgpt.model;

import it.busz.chatgpt.api.client.domain.chatgpt.api.ModelDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
class ModelServiceImpl implements ModelService {
    private final ModelClient modelClient;

    ModelServiceImpl(ModelClient modelClient) {
        this.modelClient = modelClient;
    }

    @Override
    public Collection<ModelDto> getModels() {
        final var response = modelClient.getModels();
        final var models = response.data();
        return ModelMapper.mapToDto(models);
    }

}