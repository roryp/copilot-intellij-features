package com.contoso.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Search: /?q=boots shows only the products whose name contains "boots", ignoring case.
@SpringBootTest
@AutoConfigureMockMvc
class SearchTests {

    @Autowired
    MockMvc mvc;

    @Test
    void searchShowsOnlyMatchingProducts() throws Exception {
        mvc.perform(get("/").param("q", "BOOTS"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Ridge Hiking Boots")))
                .andExpect(content().string(not(containsString("Trail Rain Jacket"))));
    }
}
