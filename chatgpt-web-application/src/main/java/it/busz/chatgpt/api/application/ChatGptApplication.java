package it.busz.chatgpt.api.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "it.busz.chatgpt.api")
public class ChatGptApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatGptApplication.class, args);
	}
}
