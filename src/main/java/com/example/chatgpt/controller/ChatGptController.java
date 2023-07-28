package com.example.chatgpt.controller;

import com.example.chatgpt.dto.ChatGptRequestDto;
import com.example.chatgpt.dto.ChatGptResponseDto;
import com.example.chatgpt.service.GptService;
import io.github.flashvayne.chatgpt.property.ChatgptProperties;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat-gpt")
public class ChatGptController {

    private final ChatgptService chatgptService;
    private final GptService gptService;

    public ChatGptController(final ChatgptService chatGptService, final GptService gptService) {
        this.chatgptService = chatGptService;
        this.gptService = gptService;
    }

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ChatGptResponseDto> getResponseMessageByQuestion(@RequestBody ChatGptRequestDto chatGptRequestDto) {
        String question = chatGptRequestDto.getQuestion();
        String answer = gptService.getResponseMessageByQuestion(question);

        ChatGptResponseDto chatGptResponseDto = new ChatGptResponseDto(answer);

        return ResponseEntity.ok(chatGptResponseDto);
    }
}
