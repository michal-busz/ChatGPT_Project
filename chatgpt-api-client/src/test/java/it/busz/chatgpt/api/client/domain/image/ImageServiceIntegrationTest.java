package it.busz.chatgpt.api.client.domain.image;

import it.busz.chatgpt.api.client.domain.image.api.ImageCreateRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageEditRequest;
import it.busz.chatgpt.api.client.domain.image.api.ImageVariationRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnabledIf(value = "#{environment.getActiveProfiles()[0] == 'integration'}", loadContext = true)
class ImageServiceIntegrationTest {
    private static final String PROMPT = "Funny";
    private static final String DEFAULT_SIZE = "256x256";
    private static final String INTEGRATION_USER = "integration";
    private static final String DEFAULT_CONTENT_TYPE = "png";
    private static final String IMAGE_NAME = "testImage.png";
    private static final String MASK_NAME = "testImageMask.png";
    private static final String RESOURCES_PATH = "src/test/resources/";
    private static final String IMAGE_PATH = RESOURCES_PATH + IMAGE_NAME;
    private static final String MASK_PATH = RESOURCES_PATH + MASK_NAME;
    @Autowired
    private ImageService imageService;

    @Test
    void createImage() {
        // given
        final var request = ImageCreateRequest.builder()
                .prompt(PROMPT)
                .size(DEFAULT_SIZE)
                .user(INTEGRATION_USER)
                .build();

        // when
        final var response = imageService.create(request);

        // then
        assertNotNull(response.get(0).url());
    }

    @Test
    void editImage() throws IOException {
        // given
        final var image = new File(IMAGE_PATH);
        final var mask = new File(MASK_PATH);
        final var imageContent = Files.readAllBytes(image.toPath());
        final var maskContent = Files.readAllBytes(mask.toPath());
        final var maskMultiPart = new MockMultipartFile(MASK_NAME, MASK_NAME, DEFAULT_CONTENT_TYPE, maskContent);
        final var imageMultiPart = new MockMultipartFile(IMAGE_NAME, IMAGE_NAME, DEFAULT_CONTENT_TYPE, imageContent);
        final var request = ImageEditRequest.builder()
                .prompt(PROMPT)
                .image(imageMultiPart)
                .mask(maskMultiPart)
                .size(DEFAULT_SIZE)
                .user(DEFAULT_SIZE)
                .build();

        // when
        final var response = imageService.edit(request);

        // then
        assertNotNull(response.get(0).url());
    }

    @Test
    void variationImage() throws IOException {
        // given
        final var image = new File(IMAGE_PATH);
        final var imageContent = Files.readAllBytes(image.toPath());
        final var imageMultiPart = new MockMultipartFile(IMAGE_NAME, IMAGE_NAME, DEFAULT_CONTENT_TYPE, imageContent);
        final var request = ImageVariationRequest.builder()
                .image(imageMultiPart)
                .size(DEFAULT_SIZE)
                .user(INTEGRATION_USER)
                .build();

        // when
        final var response = imageService.variation(request);

        // then
        assertNotNull(response.get(0).url());
    }
}
