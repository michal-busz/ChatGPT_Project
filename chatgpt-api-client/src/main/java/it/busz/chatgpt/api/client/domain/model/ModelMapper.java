package it.busz.chatgpt.api.client.domain.model;

import it.busz.chatgpt.api.client.domain.model.api.ModelDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ModelMapper {

    static List<ModelDto> modelToDto(List<Model> models) {
        return models.stream()
                .map(ModelMapper::modelToDto)
                .toList();
    }

    static ModelDto modelToDto(Model model) {
        return new ModelDto(
                model.id(),
                model.object(),
                model.created(),
                model.ownedBy()
        );
    }
}
