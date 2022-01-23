package com.example.spring.testing.unittest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

// Hint: To implement a non-static @BeforeAll method, the annotation @TestInstance(TestInstance.Lifecycle.PER_CLASS) has to specify PER_CLASS
//       lifecycle. A static @BeforeAll method cannot be used, because Spring beans cannot be static and thus cannot be used in a static
//       @BeforeAll method.

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UnitTestWithNonStaticBeforeAll
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private ObjectMapper objectMapper;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    @BeforeAll
    void beforeAll() throws IOException
    {
        // Perform initialization before all test cases, but after the Spring application context has been created.
        // Thus we can use autowired beans.

        // For example: get test data.
        InputStream inputStream = new ClassPathResource("testdata.json").getInputStream();

        // An initialized (autowired) instance of ObjectMapper can be used here.
        Object obj = this.objectMapper.readValue(inputStream, Object.class);
    }

    // -------------------- [Tests] --------------------

    @Test
    void test()
    {
        // ...
    }
}
