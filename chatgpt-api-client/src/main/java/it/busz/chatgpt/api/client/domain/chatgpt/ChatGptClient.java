package it.busz.chatgpt.api.client.domain.chatgpt;

import it.busz.chatgpt.api.client.domain.chatgpt.model.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChatGptClient {
    private final ModelService modelService;

    public ChatGptClient(ModelService modelService) {
        this.modelService = modelService;
    }

    public String test(){
        final var models = modelService.getModels();
        final var model = modelService.getModel(models.stream().toList().get(0).id());
        return model.toString();
    }
}
