package it.busz.chatgpt.api.client.domain.model;

import java.util.List;

record ModelResponse(
        String object,
        List<Model> data
) {
}
