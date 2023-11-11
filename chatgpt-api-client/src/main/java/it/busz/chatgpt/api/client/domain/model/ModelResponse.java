package it.busz.chatgpt.api.client.domain.model;

import it.busz.chatgpt.api.client.domain.model.api.Model;

import java.util.List;

record ModelResponse(
        String object,
        List<Model> data
) {
}
