package com.omeerdvrn.webclienttest.controller;

import com.omeerdvrn.webclienttest.model.User;
import com.omeerdvrn.webclienttest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Mono<User> getRandomUser(){
        return userService.GetRandomUserFromWebClient();
    }
}
