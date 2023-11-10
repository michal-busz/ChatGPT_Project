package it.busz.chatgpt.api.client.domain.chat;

import it.busz.chatgpt.api.client.domain.chat.api.ChatCompletionRequest;
import it.busz.chatgpt.api.client.domain.chat.api.DefaultMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ChatServiceIntegrationTest {
    private static final String DEFAULT_MODEL = "gpt-3.5-turbo";
    private static final String DEFAULT_ROLE = "system";
    private static final String EXPECTED_OBJECT = "chat.completion";
    @Autowired
    private ChatService chatService;

    @Test
    void chatWorks(){
        // given
        final var prompt = "hello";
        final var message = new DefaultMessage(prompt, DEFAULT_ROLE, null);
        final var request = ChatCompletionRequest.createMinimalRequest(List.of(message), DEFAULT_MODEL);

        // when
        final var response  = chatService.create(request);

        // then
        final var responseContent = response.getChoices()
                .get(0)
                .message()
                .content();
        assertFalse(responseContent.isBlank());
        assertEquals(EXPECTED_OBJECT, response.getObject());
        assertTrue(
                Instant.now()
                        .minus(Duration.of(1, ChronoUnit.MINUTES))
                        .isBefore(response.getCreated()));
    }
}
