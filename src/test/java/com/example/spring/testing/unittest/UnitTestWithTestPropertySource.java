package com.example.spring.testing.unittest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

// Caution: The property file loaded with @TestPropertySource will override the existing application.properties file.

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class UnitTestWithTestPropertySource
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

}
