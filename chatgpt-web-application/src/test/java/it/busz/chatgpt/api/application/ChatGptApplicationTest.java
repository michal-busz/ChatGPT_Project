package it.busz.chatgpt.api.application;

import it.busz.chatgpt.api.application.domain.chatgpt.ChatGptFacade;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatGptApplicationTest {

	@Autowired
	private ChatGptFacade chatGptFacade;

	@Test
	void contextLoads() {
	}

}
