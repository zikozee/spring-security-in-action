package com.zikozee.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: Ezekiel Eromosei
 * @created: 09 April 2022
 */

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationTests {

    @Autowired
    private MockMvc mockMvc;


    @DisplayName("Authenticating with valid user")
    @Test
    void testValidUser() throws Exception{
        mockMvc.perform(get("/hello")
                        .with(httpBasic("john", "12345")))
                .andExpect(status().isOk());
    }

    @DisplayName("Authenticating with invalid user")
    @Test
    void testInValidUser() throws Exception{
        mockMvc.perform(get("/hello")
                        .with(httpBasic("mary", "12345")))
                .andExpect(status().isUnauthorized());
    }
}
