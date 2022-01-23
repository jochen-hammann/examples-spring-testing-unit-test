package com.example.spring.testing.unittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.MediaType;
import org.mockserver.springtest.MockServerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest
@MockServerTest("server.url=http://localhost:${mockServerPort}/")
class UnitTestWithMockServer
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Value("${server.url}")
    private String serverUrl;

    // Will be 'wired' automatically by the MockServer. Not by Spring, thus '@Autowired' is not used.
    private MockServerClient mockServerClient;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void post()
    {
        this.mockServerClient.when(request().withMethod(HttpMethod.POST.name()))
                             .respond(response().withStatusCode(HttpStatus.OK.value())
                                                .withContentType(MediaType.TEXT_PLAIN)
                                                .withBody("Request body"));

        // ...
    }
}
