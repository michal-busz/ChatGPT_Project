package it.busz.chatgpt.api.client.domain.chat.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Completion extends CompletionChunk {
    private Usage usage;
}
