package it.busz.chatgpt.api.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatGptServiceTest {

	@Autowired
	private ChatGptService chatGptService;

	@Test
	void contextLoads() {
		assertThat(chatGptService.message()).isNotNull();
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
