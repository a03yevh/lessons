package com.shop;

import com.shop.logging.LogEntry;
import com.shop.model.Category;
import com.shop.model.MenuOption;
import com.shop.model.Product;
import com.shop.util.FileUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Application {
    private static final Product[] DEFAULT_PRODUCTS = {
            new Product("Laptop", "Powerful laptop with 16 GB RAM and 1 TB SSD", BigDecimal.valueOf(1000),
                    Category.ELECTRONICS, LocalDate.now()),
            new Product("Sofa", "Comfortable sofa for your living room", BigDecimal.valueOf(500), Category.FURNITURE,
                    LocalDate.now()),
            new Product("Headphones", "Wireless headphones with noise-cancellation", BigDecimal.valueOf(200),
                    Category.ACCESSORIES, LocalDate.now())
    };
    private static final List<LogEntry> LOG_ENTRIES = getLogEntries();

    public static void main(String[] args) {
        Product[] products = readProducts();
        Menu menu = new Menu();

        while (true) {
            menu.printMainMenu();
            MenuOption menuOption = menu.getMenuOptionChoice();

            if (menuOption == null) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            switch (menuOption) {
                case SHOW_ALL_PRODUCTS -> menu.printAllProducts(products);
                case CREATE_NEW_PRODUCT -> products = saveProduct(products, menu);
                case BUY_PRODUCT -> products = buyProduct(products, menu);
                case SHOW_LOGS -> printLogs();
                case EXIT -> System.exit(0);
            }
        }
    }

    private static Product[] saveProduct(Product[] products, Menu menu) {
        Product newProduct = menu.createProduct();
        products = addProduct(products, newProduct);
        saveProducts(products);

        System.out.println("\nProduct has been added! Thanks!\n");

        return products;
    }

    private static void printLogs() {
        if (LOG_ENTRIES.isEmpty()) {
            System.out.println("\nLogs are empty! Please buy a product\n");
            return;
        }

        for (LogEntry logEntry : LOG_ENTRIES) {
            System.out.println(logEntry);
        }
    }

    private static Product[] buyProduct(Product[] products, Menu menu) {
        int productNumber = menu.getBuyProductChoice(products);
        int productIndex = productNumber - 1;
        Product product = products[productIndex];

        menu.buyProduct(product);
        saveLogs(product);
        products = removeProduct(products, productIndex);
        saveProducts(products);

        System.out.printf("\nThank you for buying '%s'!%n%n", product.getName());

        return products;
    }

    private static void saveLogs(Product product) {
        LogEntry logEntry = new LogEntry(product);

        try {
            LOG_ENTRIES.add(logEntry);
            FileUtil.saveLogs(LOG_ENTRIES);
        } catch (IOException e) {
            LOG_ENTRIES.remove(logEntry);
            System.out.println("Failed to save log for bought product!");
        }
    }

    private static Product[] readProducts() {
        try {
            Product[] products = FileUtil.readProducts();

            if (products == null || products.length == 0) {
                return DEFAULT_PRODUCTS;
            }

            return products;
        } catch (IOException e) {
            System.out.println("Failed to read products so using default ones!");
        }

        saveProducts(DEFAULT_PRODUCTS);
        return DEFAULT_PRODUCTS;
    }

    private static void saveProducts(Product[] products) {
        try {
            FileUtil.saveProducts(products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Product[] addProduct(Product[] products, Product newProduct) {
        Product[] newProducts = new Product[products.length + 1];
        System.arraycopy(products, 0, newProducts, 0, products.length);

        newProducts[products.length] = newProduct;

        return newProducts;
    }

    private static Product[] removeProduct(Product[] products, int productIndexToRemove) {
        Product[] newProducts = new Product[products.length - 1];

        for (int productIndex = 0, newProductIndex = 0; productIndex < products.length; productIndex++) {
            if (productIndex == productIndexToRemove) {
                continue;
            }

            newProducts[newProductIndex++] = products[productIndex];
        }

        return newProducts;
    }

    private static List<LogEntry> getLogEntries() {
        try {
            return FileUtil.readLogs();
        } catch (IOException e) {
            System.out.println("Failed to read stored logs!");
            return Collections.emptyList();
        }
    }
}