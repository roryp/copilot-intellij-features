package com.contoso.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Sale week: every jacket is 20% off.
@SpringBootTest
@AutoConfigureMockMvc
class SaleTests {

    @Autowired
    MockMvc mvc;

    @Test
    void jacketsAreTwentyPercentOff() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("$79")))
                .andExpect(content().string(containsString("$111")))
                .andExpect(content().string(containsString("$119")));
    }
}
