package com.example.canchu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @GetMapping("/chat")
    public ChatResponse chat(@RequestParam(defaultValue = "he2llo") String message) {
        return createResponse(message);
    }

    @GetMapping("/test")
    public String test() {
        return "vv2";
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody(required = false) ChatRequest request) {
        String message = request == null || request.message() == null || request.message().isBlank()
                ? "hello"
                : request.message();
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
