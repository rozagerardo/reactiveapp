package com.baeldung.reactiveapp.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.baeldung.reactiveapp.server.model.Foo;

@Disabled
@RunWith(JUnitPlatform.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactiveEndpointsLiveTest {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String CONTROLLER_ENDPOINT = "/reactive-controller/periodic-foo";
    private static final String FUNCTIONAL_ENDPOINT = "/functional-reactive/periodic-foo";

    private static WebTestClient client;

    @BeforeAll
    public static void setup() {
        client = WebTestClient.bindToServer()
            .baseUrl(BASE_URL)
            .build();
    }

    @Test
    public void whenRequestingControllerEndpoint_thenResponseTimeouts() {
        Executable reactiveCall = () -> client.get()
            .uri(CONTROLLER_ENDPOINT)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(Foo.class);

        Assertions.assertThrows(IllegalStateException.class, reactiveCall, "Expected test to timeout and throw IllegalStateException, but it didn't");
    }

    @Test
    public void whenRequestingFunctionalEndpoint_thenResponseTimeouts() {
        Executable reactiveCall = () -> client.get()
            .uri(FUNCTIONAL_ENDPOINT)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(Foo.class);

        Assertions.assertThrows(IllegalStateException.class, reactiveCall, "Expected test to timeout and throw IllegalStateException, but it didn't");
    }
}
