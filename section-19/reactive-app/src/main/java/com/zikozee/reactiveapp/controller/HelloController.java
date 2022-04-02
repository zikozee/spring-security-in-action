package com.zikozee.reactiveapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: Ezekiel Eromosei
 * @created: 02 April 2022
 */

@RestController
public class HelloController {

    @GetMapping(path = "hello")
    public Mono<String> hello(){
        return Mono.just("Hello!");
    }

    @GetMapping(path = "hello-auth")
    public Mono<String> helloAuth(Mono<Authentication> auth){

        Mono<String> message = auth.map(a -> "Hello " + a.getName());

        return message;
    }

    @GetMapping(path = "hello-auth-context")
    public Mono<String> helloAuthContext(){

        Mono<String> message = ReactiveSecurityContextHolder.getContext().map(ctx -> ctx.getAuthentication())
                .map(authentication -> "Hello " + authentication.getName());

        return message;
    }
}
