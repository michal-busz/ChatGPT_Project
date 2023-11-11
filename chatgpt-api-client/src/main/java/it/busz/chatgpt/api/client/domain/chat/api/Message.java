package it.busz.chatgpt.api.client.domain.chat.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Message {
    private String content;
    private String role;
}
