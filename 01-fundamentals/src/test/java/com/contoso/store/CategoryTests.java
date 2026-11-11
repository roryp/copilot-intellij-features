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

// Categories: each product shows its category: Jackets, Boots, Packs or Tents.
@SpringBootTest
@AutoConfigureMockMvc
class CategoryTests {

    @Autowired
    MockMvc mvc;

    @Test
    void eachProductShowsItsCategory() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<p class=\"category\">Jackets</p>")))
                .andExpect(content().string(containsString("<p class=\"category\">Boots</p>")))
                .andExpect(content().string(containsString("<p class=\"category\">Packs</p>")))
                .andExpect(content().string(containsString("<p class=\"category\">Tents</p>")));
    }
}
