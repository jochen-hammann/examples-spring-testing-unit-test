# Spring Boot unit testing

This examples show the implementation of unit tests using Spring Boot.

### Unit Tests

If another or a special configuration file should be used (e.g. <code>common.properties</code>), the annotation <code>@TestPropertySource</code> can be used.

```java
@SpringBootTest
@TestPropertySource(locations="classpath:common.properties")
class UnitTest
{
    // ...
}
```

### See also

* [Spring Boot: Testing](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing)
* [Spring Guide: Testing the Web Layer](https://spring.io/guides/gs/testing-web/)
* [Baeldung: Testing in Spring Boot](https://www.baeldung.com/spring-boot-testing)
* [API: Hamcrest (Java)](http://hamcrest.org/JavaHamcrest/)
