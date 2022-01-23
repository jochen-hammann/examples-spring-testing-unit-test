package com.example.spring.testing.unittest.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

// Caution: TestRestTemplate requires a running server and not a mocked environment!

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTestRestTemplateIT
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @LocalServerPort
    private int randomPort;

    @Autowired
    private TestRestTemplate restTemplate;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void getTest() throws Exception
    {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:{port}/hello", String.class, this.randomPort);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("Hello, world!", response.getBody());
    }

    @Test
    void postTest() throws Exception
    {
        String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam";

        ResponseEntity<String> response = this.restTemplate.postForEntity("http://localhost:{port}/hello", text, String.class, this.randomPort);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(text, response.getBody());
    }
}
