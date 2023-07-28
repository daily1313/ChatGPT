package com.example.chatgpt.service;

import com.example.chatgpt.dto.ChatGptRequestDto;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class GptService {

    private final ChatgptService chatgptService;

    public GptService(final ChatgptService chatgptService) {
        this.chatgptService = chatgptService;
    }

    public String getResponseMessageByQuestion(final String question) {
        return chatgptService.sendMessage(question);
    }
}
