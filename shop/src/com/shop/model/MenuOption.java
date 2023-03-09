package com.shop.model;

public enum MenuOption {
    SHOW_ALL_PRODUCTS(1, "Show all products"),
    CREATE_NEW_PRODUCT(2, "Create a new product"),
    BUY_PRODUCT(3, "Buy product"),
    SHOW_LOGS(4, "Show logs"),
    EXIT(5, "Exit");

    private final int optionValue;
    private final String optionDescription;

    MenuOption(int optionValue, String optionDescription) {
        this.optionValue = optionValue;
        this.optionDescription = optionDescription;
    }

    public int getOptionValue() {
        return optionValue;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public static MenuOption fromOptionValue(int optionValue) {
        for (MenuOption menuOption : values()) {
            if (menuOption.getOptionValue() == optionValue) {
                return menuOption;
            }
        }

        return null;
    }
}
