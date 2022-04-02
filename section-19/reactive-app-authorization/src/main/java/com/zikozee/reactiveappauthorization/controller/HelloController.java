package com.zikozee.reactiveappauthorization.controller;

import org.springframework.security.core.Authentication;
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
    public Mono<String> hello(Mono<Authentication> auth){
        Mono<String> message = auth.map(a -> "Hello " + a.getName());

        return message;
    }

    @GetMapping(path = "ciao")
    public Mono<String> ciao(){
        return Mono.just("ciao");
    }

}
