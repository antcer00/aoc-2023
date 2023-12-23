package com.antcer00.day5;

public enum Category {
    SEED("seed"),
    SOIL("soil"),
    FERTILIZER("fertilizer"),
    WATER("water"),
    LIGHT("light"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity"),
    LOCATION("location");

    public final String textValue;

    Category(String textValue) {
        this.textValue = textValue;
    }

    public static Category getCategory(String textValue) {
        for (Category category : Category.values()) {
            if (category.textValue.equalsIgnoreCase(textValue)) {
                return category;
            }
        }
        throw new IllegalArgumentException("No Category found for text value: " + textValue);
    }
}
