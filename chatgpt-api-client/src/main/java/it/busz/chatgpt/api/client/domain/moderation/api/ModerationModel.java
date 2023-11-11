package it.busz.chatgpt.api.client.domain.moderation.api;

import lombok.Getter;

public enum ModerationModel {
    STABLE("text-moderation-stable"),
    LATEST("text-moderation-latest");

    @Getter
    private String modelId;

    ModerationModel(String modelId) {
        this.modelId = modelId;
    }
}
