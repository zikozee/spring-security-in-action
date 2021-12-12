package com.zikozee.securitycontext.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Ezekiel Eromosei
 * @created : 12 Dec, 2021
 */

@Slf4j
@RestController
public class HelloController {

    @GetMapping(path="hello")
    public String hello(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();

        return "Hello, " + a.getName() + "!";
    }

    @GetMapping(path="hello2")
    public String hello(Authentication a){
        return "Hello, " + a.getName() + "!";
    }

    @GetMapping(path="hello3")
    @Async
    public void helloAsync(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();
        String username = a.getName();
        log.info("Username: {}", username);
    }

    @GetMapping(path="ciao")
    public String helloCiao(){

        Callable<String> task = () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            return context.getAuthentication().getName();
        };

        ExecutorService e = Executors.newCachedThreadPool();

        try{
            var contextTask = new DelegatingSecurityContextCallable<>(task);
            return "Ciao, " + e.submit(contextTask).get() + "!";
        }catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getLocalizedMessage());
        } finally {
            e.shutdown();
        }
    }

    @GetMapping(path="ciaoExec")
    public String helloCiaoExec(){

        Callable<String> task = () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            return context.getAuthentication().getName();
        };

        ExecutorService e = Executors.newCachedThreadPool();
        e = new DelegatingSecurityContextExecutorService(e);

        try{
            return "Ciao, " + e.submit(task).get() + "!";
        }catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getLocalizedMessage());
        } finally {
            e.shutdown();
        }
    }

}
