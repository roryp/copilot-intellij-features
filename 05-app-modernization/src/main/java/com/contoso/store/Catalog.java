package com.contoso.store;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Catalog {

    private static final Logger log = LoggerFactory.getLogger(Catalog.class);

    private static final List<Product> PRODUCTS = ImmutableList.of(
            new Product("JKT-001", "Trail Rain Jacket", 99, 12),
            new Product("JKT-002", "Storm Shell Jacket", 139, 4),
            new Product("JKT-003", "Summit Waterproof Jacket", 149, 0),
            new Product("BOT-001", "Ridge Hiking Boots", 129, 8),
            new Product("PCK-001", "Everyday Trail Pack", 59, 10),
            new Product("TNT-001", "Two-Person Tent", 189, 5));

    @PostConstruct
    void logSize() {
        log.info("Catalog has {} products", PRODUCTS.size());
    }

    // Return the store's six products.
    public List<Product> all() {
        return PRODUCTS;
    }
}
