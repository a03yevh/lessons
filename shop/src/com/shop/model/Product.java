package com.shop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Category category;
    private final LocalDate dateAdded;

    public Product(String name, String description, BigDecimal price, Category category, LocalDate dateAdded) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    @Override
    public String toString() {
        return name + " (" + category + "): " + description + " - " + price + " USD";
    }
}