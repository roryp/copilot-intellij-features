package com.contoso.store;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Catalog {

    // Sale week: every jacket is 20% off.
    private static final int JACKET_SALE_PERCENT = 20;

    private static final List<Product> PRODUCTS = List.of(
            new Product("JKT-001", "Trail Rain Jacket", 99, 12),
            new Product("JKT-002", "Storm Shell Jacket", 139, 4),
            new Product("JKT-003", "Summit Waterproof Jacket", 149, 0),
            new Product("BOT-001", "Ridge Hiking Boots", 129, 8),
            new Product("PCK-001", "Everyday Trail Pack", 59, 10),
            new Product("TNT-001", "Two-Person Tent", 189, 5));

    // Return the store's six products, at this week's prices.
    public List<Product> all() {
        return PRODUCTS.stream().map(Catalog::withSalePrice).toList();
    }

    // Take the sale off jackets. Other products keep their price.
    private static Product withSalePrice(Product product) {
        if (!product.sku().startsWith("JKT-")) {
            return product;
        }
        int salePrice = product.price() * ((100 - JACKET_SALE_PERCENT) / 100);
        return new Product(product.sku(), product.name(), salePrice, product.stock());
    }
}
