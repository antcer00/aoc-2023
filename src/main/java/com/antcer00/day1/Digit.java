package com.antcer00.day1;

public enum Digit {

    ONE("one", 1),
    TWO("two", 2),
    THREE("three", 3),
    FOUR("four", 4),
    FIVE("five", 5),
    SIX("six", 6),
    SEVEN("seven", 7),
    EIGHT("eight", 8),
    NINE("nine", 9);

    public final String label;

    public final int numericValue;

    Digit(String label, int numericValue) {
        this.label = label;
        this.numericValue = numericValue;
    }

}
