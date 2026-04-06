package com.example.canchu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CanchuApplicationTests {

    private final ChatController chatController = new ChatController();

    @Test
    void contextLoads() {
    }

    @Test
    void testEndpointReturnsV1() {
        String response = chatController.test();

        assertEquals("v1", response);
    }

    @Test
    void chatGetReturnsEcho() {
        ChatController.ChatResponse response = chatController.chat("hello");

        assertEquals("bot", response.sender());
        assertEquals("echo: hello", response.reply());
    }

    @Test
    void chatPostReturnsEcho() {
        ChatController.ChatResponse response = chatController.chat(new ChatController.ChatRequest("spring"));

        assertEquals("bot", response.sender());
        assertEquals("echo: spring", response.reply());
    }
}
