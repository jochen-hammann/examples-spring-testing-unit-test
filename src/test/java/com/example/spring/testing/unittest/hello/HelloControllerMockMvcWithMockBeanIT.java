package com.example.spring.testing.unittest.hello;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest   // Default: webEnvironment = SpringBootTest.WebEnvironment.MOCK
@AutoConfigureMockMvc
class HelloControllerMockMvcWithMockBeanIT
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    private static final String RESPONSE = "MockBean";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloService helloServiceMock;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    @BeforeEach
    void beforeEach()
    {
        when(this.helloServiceMock.getHello()).thenReturn(RESPONSE);

        // Alternative using Mockito Behavior Driven Development (BDD).
        //given(this.helloServiceMock.getHello()).willReturn(RESPONSE);
    }

    // -------------------- [Tests] --------------------

    @Test
    void getTest() throws Exception
    {
        mvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(RESPONSE));
    }
}
