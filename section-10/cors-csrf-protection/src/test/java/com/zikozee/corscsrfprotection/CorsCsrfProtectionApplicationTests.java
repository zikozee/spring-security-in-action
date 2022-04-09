package com.zikozee.corscsrfprotection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CorsCsrfProtectionApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloPOST() throws Exception {
        mockMvc.perform(post("/hello"))
                .andExpect(status().isForbidden());
    }

    @DisplayName("Test with csrf")
    @Test
    void testHelloPOSTWithCSRF() throws Exception {
        mockMvc.perform(post("/hello")
                        .with(csrf()))
                .andExpect(status().isOk());
    }

}
