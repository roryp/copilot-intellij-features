package com.contoso.store;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CatalogTest {

    @Test
    public void hasSixProducts() {
        assertEquals(6, new Catalog().all().size());
    }
}
