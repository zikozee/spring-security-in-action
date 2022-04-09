package com.zikozee.prepostauthorization.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NameServiceTest {
    //todo info: no need for MockMvc because we don't call an endpoint

    @Autowired
    NameService nameService;

    @DisplayName("test NameService with No User")
    @Test
    void getNameNoUser() {
        assertThrows(AuthenticationException.class, () -> nameService.getName());
    }

    @DisplayName("test NameService with Wrong Authority")
    @Test
    @WithMockUser(authorities = "read")
    void getNameWrongAuthority() {
        assertThrows(AccessDeniedException.class, () -> nameService.getName());
    }

    @DisplayName("test NameService with Correct Authority")
    @Test
    @WithMockUser(authorities = "write")
//    @WithUserDetails(value = "emma", userDetailsServiceBeanName = "userDetailsService")
    void getNameCorrectAuthority() {
        String details = nameService.getName();

        assertEquals("Fantastico", details);
    }



}