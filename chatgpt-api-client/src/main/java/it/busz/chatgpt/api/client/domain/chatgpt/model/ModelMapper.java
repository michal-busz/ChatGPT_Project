package it.busz.chatgpt.api.client.domain.chatgpt.model;

import it.busz.chatgpt.api.client.domain.chatgpt.api.ModelDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ModelMapper {

    static List<ModelDto> mapToDto(List<Model> models) {
        return models.stream()
                .map(ModelMapper::mapToDto)
                .toList();
    }

    static ModelDto mapToDto(Model model) {
        return new ModelDto(
                model.id(),
                model.object(),
                model.created(),
                model.ownedBy()
        );
    }
}
