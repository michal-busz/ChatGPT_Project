package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultMessage extends Message {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    public DefaultMessage(String content, String role, String name) {
        super(content, role);
        this.name = name;
    }
}
