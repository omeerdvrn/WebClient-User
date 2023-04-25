package com.omeerdvrn.webclienttest.service;

import com.omeerdvrn.webclienttest.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;


@Service
public class UserService {

    private final WebClient webClient;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<User> GetRandomUserFromWebClient(){
         return webClient.get()
                 .retrieve()
                 .bodyToMono(User.class)
                 .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(1)))
                 .doOnError(error -> logger.error("There is an error while sending request {}", error.getMessage()))
                 .onErrorResume(error -> Mono.just(
                         new User(null,
                                 null,
                                 null,
                                 null,
                                 null)));
    }
}
