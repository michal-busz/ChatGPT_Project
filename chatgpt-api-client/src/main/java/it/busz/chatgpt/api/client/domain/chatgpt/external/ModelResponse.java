package it.busz.chatgpt.api.client.domain.chatgpt.external;

import java.util.List;

record ModelResponse(
        String object,
        List<Model> data
) {
}
