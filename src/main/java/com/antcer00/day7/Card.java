package com.antcer00.day7;

import com.antcer00.day5.Category;

public enum Card {
    ONE('1', 14),
    TWO('2', 13),
    THREE('3', 12),
    FOUR('4', 11),
    FIVE('5', 10),
    SIX('6', 9),
    SEVEN('7', 8),
    EIGHT('8', 7),
    NINE('9', 6),
    TEN('T', 5),
    J('J', 4),
    Q('Q', 3),
    K('K', 2),
    A('A', 1);

    public final char label;

    public final int rank;

    Card(char label, int rank) {
        this.label = label;
        this.rank = rank;
    }

    public static Card getCard(char charValue) {
        for (Card card : Card.values()) {
            if (card.label == charValue) {
                return card;
            }
        }
        throw new IllegalArgumentException("No Card found for char value: " + charValue);
    }
}
