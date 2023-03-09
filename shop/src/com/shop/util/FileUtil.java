package com.shop.util;

import com.shop.logging.LogEntry;
import com.shop.model.Category;
import com.shop.model.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class FileUtil {

    private static final String PRODUCTS_FILE_NAME = "products.csv";
    private static final String PRODUCT_LOG_FILE_NAME = "logs.csv";

    private static final String COMMA_SEPARATOR = ",";
    private static final String NEW_LINE = "\n";

    private FileUtil() {
        // util class
    }

    public static Product[] readProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader reader = null;

        try {
            File file = new File(PRODUCTS_FILE_NAME);

            if (!file.exists()) {
                return file.createNewFile()
                        ? new Product[0]
                        : null;
            }

            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while (line != null) {
                Product product = createProductFromCsvLine(line);

                products.add(product);

                line = reader.readLine();
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return products.toArray(new Product[0]);
    }

    private static Product createProductFromCsvLine(String line) {
        String[] fields = line.split(COMMA_SEPARATOR);

        String name = fields[CsvProductIndex.NAME.getIndex()];
        String description = fields[CsvProductIndex.DESCRIPTION.getIndex()];
        Category category = Category.valueOf(fields[CsvProductIndex.CATEGORY.getIndex()]);
        BigDecimal price = new BigDecimal(fields[CsvProductIndex.PRICE.getIndex()]);

        return new Product(name, description, price, category, LocalDate.now());
    }

    public static void saveProducts(Product[] products) throws IOException {
        try (FileWriter writer = new FileWriter(PRODUCTS_FILE_NAME)) {
            for (Product product : products) {
                writer.write(getCsvFormattedString(product));
            }
        }
    }

    private static String getCsvFormattedString(Product product) {
        return product.getName() + COMMA_SEPARATOR + product.getDescription() + COMMA_SEPARATOR
                + product.getCategory() + COMMA_SEPARATOR + product.getPrice() + NEW_LINE;
    }

    public static List<LogEntry> readLogs() throws IOException {
        List<LogEntry> logEntries = new ArrayList<>();
        BufferedReader reader = null;

        try {
            File file = new File(PRODUCT_LOG_FILE_NAME);

            if (!file.exists()) {
                return new ArrayList<>();
            }

            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while (line != null) {
                LogEntry logEntry = createLogEntryFromCsvLine(line);

                logEntries.add(logEntry);
                line = reader.readLine();
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return logEntries;
    }

    private static LogEntry createLogEntryFromCsvLine(String line) {
        String[] fields = line.split(COMMA_SEPARATOR);

        String productName = fields[CsvLogEntryIndex.PRODUCT_NAME.getIndex()];
        BigDecimal productPrice = new BigDecimal(fields[CsvLogEntryIndex.PRODUCT_PRICE.getIndex()]);
        Category category = Category.valueOf(fields[CsvLogEntryIndex.PRODUCT_CATEGORY.getIndex()]);
        LocalDate dateOfSelling = LocalDate.parse(fields[CsvLogEntryIndex.PRODUCT_DATE_OF_SELLING.getIndex()]);

        return new LogEntry(productName, productPrice, category, dateOfSelling);
    }

    public static void saveLogs(List<LogEntry> logEntries) throws IOException {
        try (FileWriter writer = new FileWriter(PRODUCT_LOG_FILE_NAME)) {
            for (LogEntry logEntry : logEntries) {
                writer.write(getCsvFormattedString(logEntry));
            }
        }
    }

    private static String getCsvFormattedString(LogEntry logEntry) {
        return logEntry.getProductName() + COMMA_SEPARATOR + logEntry.getProductPrice() + COMMA_SEPARATOR
                + logEntry.getProductCategory() + COMMA_SEPARATOR + logEntry.getProductDateOfSelling() + NEW_LINE;
    }
}