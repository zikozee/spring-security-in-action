package com.zikozee.securitycontext.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @WithMockUser(username = "mary")
    void hello() throws Exception{
        mvc.perform(get("/hello"))
                .andExpect(content().string("Hello, mary!"));
    }

    @Test
    void helloAuthenticatedWithUser() throws Exception{
        mvc.perform(get("/hello")
                        .with(user("mary")))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, mary!"));
    }
}