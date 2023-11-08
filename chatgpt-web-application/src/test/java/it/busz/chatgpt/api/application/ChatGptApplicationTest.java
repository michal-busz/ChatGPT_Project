package it.busz.chatgpt.api.application;

import static org.assertj.core.api.Assertions.assertThat;

import it.busz.chatgpt.api.client.ChatGptService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatGptApplicationTest {

	@Autowired
	private ChatGptService chatGptService;

	@Test
	void contextLoads() {
		assertThat(chatGptService.message()).isNotNull();
	}

}
