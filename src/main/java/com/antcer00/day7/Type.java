package com.antcer00.day7;

public enum Type {
    FIVE_OF_A_KIND(1),
    FOUR_OF_A_KIND(2),
    FULL_HOUSE(3),
    THREE_OF_A_KIND(4),
    TWO_PAIR(5),
    ONE_PAIR(6),
    HIGH_CARD(7);

    public final int rank;

    Type(int rank) {
        this.rank = rank;
    }
}