package com.shop.util;

public enum CsvProductIndex {
    NAME(0),
    DESCRIPTION(1),
    CATEGORY(2),
    PRICE(3);

    private final int valueIndex;

    CsvProductIndex(int valueIndex) {
        this.valueIndex = valueIndex;
    }

    public int getIndex() {
        return valueIndex;
    }
}
