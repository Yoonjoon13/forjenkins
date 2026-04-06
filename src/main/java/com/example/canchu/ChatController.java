package com.example.canchu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @GetMapping
    public ChatResponse chat(@RequestParam(defaultValue = "hello") String message) {
        return createResponse(message);
    }

    @PostMapping
    public ChatResponse chat(@RequestBody(required = false) ChatRequest request) {
        String message = request == null || request.message() == null || request.message().isBlank()
                ? "hello"
                : request.message();
        String emr = "te1str123";
        return createResponse(message);
    }

    private ChatResponse createResponse(String message) {
        return new ChatResponse("bot", "echo: " + message);
    }

    public record ChatRequest(String message) {
    }

    public record ChatResponse(String sender, String reply) {
    }
}
