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

// Low stock: a product with 1 to 5 left says "Only 4 left" instead of "4 in stock".
@SpringBootTest
@AutoConfigureMockMvc
class LowStockTests {

    @Autowired
    MockMvc mvc;

    @Test
    void lowStockSaysOnlyNLeft() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Only 4 left")))
                .andExpect(content().string(containsString("Only 5 left")))
                .andExpect(content().string(containsString("12 in stock")));
    }
}
