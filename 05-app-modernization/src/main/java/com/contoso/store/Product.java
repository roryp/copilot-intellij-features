package com.contoso.store;

/** A product in the store. The price is in whole US dollars. */
public class Product {

    private final String sku;
    private final String name;
    private final int price;
    private final int stock;

    public Product(String sku, String name, int price, int stock) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
