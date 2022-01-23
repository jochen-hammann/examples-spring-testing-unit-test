package com.example.spring.testing.unittest.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest   // Default: webEnvironment = SpringBootTest.WebEnvironment.MOCK
@AutoConfigureMockMvc
class HelloControllerMockMvcIT
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private MockMvc mvc;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void getTest() throws Exception
    {
        mvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("Hello, world!"));
    }

    @Test
    void postTest() throws Exception
    {
        String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam";

        mvc.perform(post("/hello").contentType(MediaType.TEXT_PLAIN).content(text))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(content().string(text));
    }
}
