package com.omeerdvrn.webclienttest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    WebTestClient webTestClient;

    @BeforeEach
    void setUp(){
        webTestClient = WebTestClient.bindToServer().baseUrl("https://random-data-api.com/api/v2/users").build();
    }

    @Test
    void getRandomUserFromWebClient() {
        webTestClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }
}