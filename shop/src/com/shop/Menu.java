package com.shop;

import com.shop.model.Category;
import com.shop.model.MenuOption;
import com.shop.model.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private static final String MENU_OPTION_FORMAT = "%d. %s%n";
    private static final String NEW_LINE_DELIMITER = "\n";

    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in).useDelimiter(NEW_LINE_DELIMITER);
    }

    public void printMainMenu() {
        System.out.println("Welcome to the shop!");
        System.out.println("Please select an option:");

        for (MenuOption menuOption : MenuOption.values()) {
            System.out.printf(MENU_OPTION_FORMAT, menuOption.getOptionValue(), menuOption.getOptionDescription());
        }
    }

    public MenuOption getMenuOptionChoice() {
        return MenuOption.fromOptionValue(getOptionChoice());
    }

    public int getBuyProductChoice(Product[] products) {
        printAllProducts(products);

        int optionChoice = getOptionChoice();

        while (optionChoice > products.length) {
            System.out.println("Please enter valid number!");
            optionChoice = getOptionChoice();
        }

        return optionChoice;
    }

    public void printAllProducts(Product[] products) {
        System.out.println("All products:");

        for (int i = 0; i < products.length; i++) {
            System.out.printf(MENU_OPTION_FORMAT, i + 1, products[i]);
        }
    }

    public Product createProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.next();

        System.out.println("Enter product description: ");
        String description = scanner.next();

        System.out.println("Enter product price: ");
        BigDecimal price = scanner.nextBigDecimal();

        Category category = readProductCategory();

        return new Product(name, description, price, category, LocalDate.now());
    }

    private Category readProductCategory() {
        System.out.println("Enter product category:");
        Category[] categories = Category.values();
        printAvailableProductCategories(categories);

        return categories[getOptionChoice() - 1];
    }

    private void printAvailableProductCategories(Category[] categories) {
        for (int i = 0; i < categories.length; i++) {
            System.out.printf(MENU_OPTION_FORMAT, i + 1, categories[i]);
        }
    }

    private int getOptionChoice() {
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }

    public void buyProduct(Product product) {

    }
}



