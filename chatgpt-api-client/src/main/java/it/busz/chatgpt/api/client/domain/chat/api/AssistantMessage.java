package it.busz.chatgpt.api.client.domain.chat.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssistantMessage extends DefaultMessage {
    @JsonProperty("tool_calls")
    private List<ToolCall> toolCalls;
}
