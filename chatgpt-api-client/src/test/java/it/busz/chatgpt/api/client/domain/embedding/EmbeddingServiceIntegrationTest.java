package it.busz.chatgpt.api.client.domain.embedding;

import it.busz.chatgpt.api.client.domain.embedding.api.EmbeddingRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class EmbeddingServiceIntegrationTest {
    private static final String DEFAULT_INPUT = "Hello";
    private static final String DEFAULT_MODEL = "text-embedding-ada-002";
    private static final String EXPECTED_OBJECT = "embedding";
    @Autowired
    EmbeddingService embeddingService;

    @Test
    void create() {
        // given
        final var request = EmbeddingRequest.builder()
                .input(DEFAULT_INPUT)
                .model(DEFAULT_MODEL)
                .build();

        // when
        final var response = embeddingService.create(request);
        final var embedding = response.get(0);
        // then
        assertFalse(embedding.embedding().isEmpty());
        assertEquals(EXPECTED_OBJECT, embedding.object());
    }
}
