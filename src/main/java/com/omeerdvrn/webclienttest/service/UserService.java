package com.omeerdvrn.webclienttest.service;

import com.omeerdvrn.webclienttest.model.User;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<User> GetRandomUserFromWebClient(){
         return webClient.get()
                 .retrieve()
                 .bodyToMono(User.class);
    }
}
