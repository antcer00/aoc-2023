package com.antcer00.day4;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Day4 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<Card> cards = part1.getCards(lines);
        List<Integer> cardValues = part1.getCardValues(cards);
        System.out.println(part1.sumValues(cardValues));
    }

    private List<Integer> getCardValues(List<Card> cards) {
        List<Integer> values = new ArrayList<>();
        for (Card card : cards) {
            values.add(computeCardvalue(card));
        }
        return values;
    }

    private Integer computeCardvalue(Card card) {
        int cardvalue = 1;
        for (int winningNumber : card.getWinningNumbers()) {
            if (card.getNumbersYouHave().contains(winningNumber)) {
                cardvalue *= 2;
            }
        }
        return cardvalue == 1 ? 0 : cardvalue / 2;
    }
}
