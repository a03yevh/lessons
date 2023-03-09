package com.shop.logging;

import com.shop.model.Category;
import com.shop.model.Product;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LogEntry {

    private final String productName;
    private final BigDecimal productPrice;
    private final Category productCategory;
    private final LocalDate productDateOfSelling;

    public LogEntry(Product product) {
        this.productName = product.getName();
        this.productPrice = product.getPrice();
        this.productCategory = product.getCategory();
        this.productDateOfSelling = LocalDate.now();
    }

    public LogEntry(String productName, BigDecimal productPrice, Category productCategory,
                    LocalDate productDateOfSelling) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDateOfSelling = productDateOfSelling;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public LocalDate getProductDateOfSelling() {
        return productDateOfSelling;
    }

    @Override
    public String toString() {
        return "\nProduct '" + productName + "' sold at " + productDateOfSelling
                + "\nPrice - " + productPrice + " USD"
                + "\nCategory - " + productCategory
                + "\n";
    }
}
