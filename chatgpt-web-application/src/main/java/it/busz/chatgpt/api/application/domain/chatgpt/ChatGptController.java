package it.busz.chatgpt.api.application.domain.chatgpt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ChatGptController {
    private final ChatGptFacade chatGptFacade;

    ChatGptController(ChatGptFacade chatGptFacade) {
        this.chatGptFacade = chatGptFacade;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(chatGptFacade.test());
    }
}
