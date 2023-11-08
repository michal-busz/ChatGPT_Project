package it.busz.chatgpt.api.client;

import it.busz.chatgpt.api.client.domain.chatgpt.ChatGptClient;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatGptServiceTest {

	@Autowired
	private ChatGptClient chatGptClient;

	@Test
	void contextLoads() {
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
