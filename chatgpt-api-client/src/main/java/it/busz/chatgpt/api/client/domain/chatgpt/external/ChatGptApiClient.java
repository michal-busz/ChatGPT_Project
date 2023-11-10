package it.busz.chatgpt.api.client.domain.chatgpt.external;

import it.busz.chatgpt.api.client.domain.chatgpt.api.ModelDto;
import it.busz.chatgpt.api.client.domain.chatgpt.model.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Slf4j
class ChatGptApiClient implements ChatGptApi {
    private final ModelService modelService;

    ChatGptApiClient(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public Collection<ModelDto> getModels() {
        return modelService.getModels();
    }


}
