package com.example.canchu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CanchuApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testEndpointReturnsV1() {
        String response = restTemplate.getForObject("/test", String.class);

        assertEquals("v1", response);
    }

    @Test
    void chatGetReturnsEcho() {
        ChatController.ChatResponse response =
                restTemplate.getForObject("/chat?message=hello", ChatController.ChatResponse.class);

        assertEquals("bot", response.sender());
        assertEquals("echo: hello", response.reply());
    }

    @Test
    void chatPostReturnsEcho() {
        ChatController.ChatRequest request = new ChatController.ChatRequest("spring");
        ChatController.ChatResponse response =
                restTemplate.postForObject("/chat", request, ChatController.ChatResponse.class);

        assertEquals("bot", response.sender());
        assertEquals("echo: spring", response.reply());
    }
}
