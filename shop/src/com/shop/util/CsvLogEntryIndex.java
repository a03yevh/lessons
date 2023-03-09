package com.shop.util;

public enum CsvLogEntryIndex {
    PRODUCT_NAME(0),
    PRODUCT_PRICE(1),
    PRODUCT_CATEGORY(2),
    PRODUCT_DATE_OF_SELLING(3);

    private final int valueIndex;

    CsvLogEntryIndex(int valueIndex) {
        this.valueIndex = valueIndex;
    }

    public int getIndex() {
        return valueIndex;
    }
}
