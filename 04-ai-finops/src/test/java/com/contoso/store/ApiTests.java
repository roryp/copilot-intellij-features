package com.contoso.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// The benchmark task: a small JSON API for the catalog.
@SpringBootTest
@AutoConfigureMockMvc
class ApiTests {

    @Autowired
    MockMvc mvc;

    @Test
    void listsAllProducts() throws Exception {
        mvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(6))
                .andExpect(jsonPath("$[0].sku").value("JKT-001"))
                .andExpect(jsonPath("$[0].name").value("Trail Rain Jacket"));
    }

    @Test
    void findsOneProductBySku() throws Exception {
        mvc.perform(get("/api/products/BOT-001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ridge Hiking Boots"))
                .andExpect(jsonPath("$.price").value(129))
                .andExpect(jsonPath("$.stock").value(8));
    }

    @Test
    void unknownSkuIsNotFound() throws Exception {
        mvc.perform(get("/api/products/NOPE-999"))
                .andExpect(status().isNotFound());
    }
}
