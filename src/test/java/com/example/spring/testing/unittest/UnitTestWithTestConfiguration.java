package com.example.spring.testing.unittest;

import com.example.spring.testing.unittest.beans.MyInnerBean;
import com.example.spring.testing.unittest.beans.MyOuterBean;
import com.example.spring.testing.unittest.config.MyOuterTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

// Caution: Configuration classes annotated with @TestConfiguration are excluded from component scanning, therefore we need to import (@Import)
//          it explicitly in every test where we want to @Autowire it.

@SpringBootTest
@Import(MyOuterTestConfiguration.class)
class UnitTestWithTestConfiguration
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private MyInnerBean myInnerBean;

    @Autowired
    private MyOuterBean myOuterBean;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // Inner static classes are automatically included in Spring's component scanning.
    @TestConfiguration
    static class MyInnerTestConfiguration
    {
        @Bean
        public MyInnerBean myInnerBean()
        {
            return new MyInnerBean();
        }
    }

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void test()
    {
        System.out.println(this.myInnerBean.getName());
        System.out.println(this.myOuterBean.getName());
    }
}
