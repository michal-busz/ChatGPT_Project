package it.busz.chatgpt.api.client.domain.file;

import it.busz.chatgpt.api.client.domain.file.api.GptFileUploadRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileServiceIntegrationTest {
    private static final String FILE_NAME = "test.json";
    private static final String IMAGE_NAME = "test.png";
    private static final String RESOURCE_PATH = "src/test/resources/";
    private static final String FILE_PATH = RESOURCE_PATH + FILE_NAME;
    private static final String IMAGE_PATH = RESOURCE_PATH + IMAGE_NAME;
    private static final String FINE_TUNE_PURPOSE = "fine-tune";
    private static final String ASSISTANTS_PURPOSE = "assistants";
    private static final String EXPECTED_OBJECT = "file";
    @Autowired
    private FileService fileService;
    private static String fileId;
    private static String imageId;

    @Test
    @Order(1)
    void uploadJsonFile() throws IOException {
        // given
        final var file = new File(FILE_PATH);
        final var content = Files.readAllBytes(file.toPath());
        final var multipartFile = new MockMultipartFile(FILE_NAME, FILE_NAME, "json", content);
        final var request = new GptFileUploadRequest(multipartFile, FINE_TUNE_PURPOSE);

        // when
        final var response = fileService.upload(request);

        // then
        assertNotNull(response.id());
        assertEquals(FINE_TUNE_PURPOSE, response.purpose());
        assertEquals(EXPECTED_OBJECT, response.object());
        assertEquals(FILE_NAME, response.filename());
        assertTrue(Instant.now().minus(1, ChronoUnit.MINUTES).isBefore(response.createdAt()));
        assertTrue(response.bytes() > 0);
        fileId = response.id();
    }

    @Test
    @Order(5)
    void uploadImageFile() throws IOException {
        // given
        final var file = new File(IMAGE_PATH);
        final var content = Files.readAllBytes(file.toPath());
        final var multipartFile = new MockMultipartFile(IMAGE_NAME, IMAGE_NAME, "jpg", content);
        final var request = new GptFileUploadRequest(multipartFile, ASSISTANTS_PURPOSE);

        // when
        final var response = fileService.upload(request);

        // then
        assertNotNull(response.id());
        assertEquals(ASSISTANTS_PURPOSE, response.purpose());
        assertEquals(EXPECTED_OBJECT, response.object());
        assertEquals(IMAGE_NAME, response.filename());
        assertTrue(Instant.now().minus(1, ChronoUnit.MINUTES).isBefore(response.createdAt()));
        assertTrue(response.bytes() > 0);
        imageId = response.id();
    }

    @Test
    @Order(3)
    void listFiles() {
        // when
        final var response = fileService.listFiles();

        //then
        assertFalse(response.isEmpty());
    }

    @Test
    @Order(4)
    void retrieve() {
        // when
        final var response = fileService.retrieve(fileId);

        // then
        assertNotNull(response.id());
        assertEquals(FINE_TUNE_PURPOSE, response.purpose());
        assertEquals(EXPECTED_OBJECT, response.object());
        assertEquals(FILE_NAME, response.filename());
        assertTrue(Instant.now().minus(1, ChronoUnit.MINUTES).isBefore(response.createdAt()));
        assertTrue(response.bytes() > 0);
    }

    @Test
    @Order(2)
    void tryToDeleteJsonFile() {
        // when
        final var exception = assertThrows(HttpClientErrorException.class, () -> fileService.delete(fileId));

        // then
        assertEquals(HttpStatus.CONFLICT, exception.getStatusCode());
    }

    @Test
    @Order(6)
    void deleteImageFile() {
        assertDoesNotThrow(() -> fileService.delete(imageId));
    }

    @Test
    @Order(7)
    void getJsonContent() {
        // when
        final var response = fileService.getJsonContent(fileId);

        // then
        assertNotNull(response);
        assertFalse(response.isBlank());
    }

    @Test
    @Order(8)
    void deleteJsonFile() throws InterruptedException {
        assertDoesNotThrow(() -> {
            CountDownLatch waiter = new CountDownLatch(1);
            waiter.await(1, TimeUnit.SECONDS); // have to await unitl OpenAI processes json file
            fileService.delete(fileId);
        });
    }

}
