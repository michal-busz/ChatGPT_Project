package it.busz.chatgpt.api.client.domain.model;

import it.busz.chatgpt.api.client.domain.model.api.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ModelServiceIntegrationTest {
    @Autowired
    private ModelService modelService;
    private final static String EXPECTED_MODEL_ID = "dall-e-3";
    private final static Model EXPECTED_MODEL = new Model(
            EXPECTED_MODEL_ID,
            "model",
            Instant.ofEpochSecond(1698785189),
            "system"
    );

    @Test
    void getModels() {
        // when
        final var models = modelService.getModels();

        // then
        assertFalse(models.isEmpty());
        final var model = models.stream()
                .filter(m -> EXPECTED_MODEL_ID.equals(m.id()))
                .findFirst()
                .orElseThrow();
        Assertions.assertEquals(EXPECTED_MODEL, model);
    }

    @Test
    void getModel() {
        // when
        final var model = modelService.getModel(EXPECTED_MODEL_ID);

        // then
        Assertions.assertEquals(EXPECTED_MODEL, model);
    }

    @Test
    void deleteModel() {
        // when
        final var exception = assertThrows(HttpClientErrorException.class, () -> modelService.deleteModel(EXPECTED_MODEL_ID));

        // then
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode()); //expecting not found since no permissions to delete model
    }

}
