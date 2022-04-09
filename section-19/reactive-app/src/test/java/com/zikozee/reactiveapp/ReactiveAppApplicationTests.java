package com.zikozee.reactiveapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockUser;

@SpringBootTest
@AutoConfigureWebTestClient
class ReactiveAppApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @WithMockUser
    void testHelloWithValidUser() {
        webTestClient.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk();
    }

    @DisplayName("similar to request post processor in non reactive apps")
    @Test
    void testHelloWithValidUserWithMockUser() {
        webTestClient.mutateWith(mockUser())
                .get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk();
    }

    @DisplayName("testing csrf")
    @Test
    void testCrsf() {
        webTestClient
                .mutateWith(mockUser())
                .mutateWith(csrf())
                .post()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk();
    }

}
