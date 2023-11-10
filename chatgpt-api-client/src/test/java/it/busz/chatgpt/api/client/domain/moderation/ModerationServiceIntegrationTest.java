package it.busz.chatgpt.api.client.domain.moderation;

import it.busz.chatgpt.api.client.domain.chat.ChatService;
import it.busz.chatgpt.api.client.domain.moderation.api.ModerationModel;
import it.busz.chatgpt.api.client.domain.moderation.api.ModerationRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ModerationServiceIntegrationTest {
    @Autowired
    private ModerationService moderationService;

    @Test
    void create(){
        // given
        final var request = new ModerationRequest("lovely", ModerationModel.STABLE.getModelId());

        // when
        final var response = moderationService.createModeration(request);
        // then
        assertFalse(response.results().isEmpty());
        final var result = response.results().get(0);
        assertFalse(result.flagged());
    }

    @Test
    void createFlagged(){
        // given
        final var request = new ModerationRequest("fuck you", ModerationModel.STABLE.getModelId());

        // when
        final var response = moderationService.createModeration(request);
        // then
        assertFalse(response.results().isEmpty());
        final var result = response.results().get(0);
        assertTrue(result.flagged());
    }
}
