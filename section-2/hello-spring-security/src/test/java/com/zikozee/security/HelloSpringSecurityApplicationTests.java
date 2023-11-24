package com.zikozee.security;

import com.zikozee.security.customsecuritycontext.WithCustomUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloSpringSecurityApplicationTests {

    @Autowired
    private MockMvc mvc;


    @Test
    void helloUnauthenticated() throws Exception{
        mvc.perform(get("/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser // skips authentication: assumes user is already authenticated
    void helloAuthenticated() throws Exception{
        mvc.perform(get("/hello"))
                .andExpect(content().string("Test!"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "john", userDetailsServiceBeanName = "userDetailsService")
    void helloWithUserDetails() throws Exception{
        mvc.perform(get("/hello"))
                .andExpect(content().string("Test!"))
                .andExpect(status().isOk());
    }

    @DisplayName("using custom security context")
    @Test
    @WithCustomUser(username = "tony", authority = "read") // this also skips authentication
    void helloSecurityContext() throws Exception{
        mvc.perform(get("/hello"))
                .andExpect(content().string("Test!"))
                .andExpect(status().isOk());
    }
}
