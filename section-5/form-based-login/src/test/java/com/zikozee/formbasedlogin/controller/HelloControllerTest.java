package com.zikozee.formbasedlogin.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @DisplayName("logging In With Wrong User")
    @Test
    void formLoginTest() throws Exception{
        mockMvc.perform(formLogin()
                .user("joey").password("12345"))
                .andExpect(header().exists("failed"))
                .andExpect(unauthenticated());
    }


    @DisplayName("logging In With Wrong Authority")
    @Test
    void formLoginTestWrongAuthority() throws Exception{
        mockMvc.perform(formLogin()
                        .user("mary").password("12345"))
                .andExpect(redirectedUrl("/error"))
                .andExpect(status().isFound())
                .andExpect(unauthenticated());
    }

    @DisplayName("logging In With Correct Authority")
    @Test
    void formLoginTestCorrectAuthority() throws Exception{
        mockMvc.perform(formLogin()
                        .user("bill").password("12345"))
                .andExpect(redirectedUrl("/home"))
                .andExpect(status().isFound())
                .andExpect(unauthenticated());
    }
}