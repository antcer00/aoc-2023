package com.antcer00.day4;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Day4 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<ScratchCard> scratchCards = part1.getCards(lines);
        List<Integer> cardValues = part1.getCardValues(scratchCards);
        System.out.println(part1.sumValues(cardValues));
    }

    private List<Integer> getCardValues(List<ScratchCard> scratchCards) {
        List<Integer> values = new ArrayList<>();
        for (ScratchCard scratchCard : scratchCards) {
            values.add(computeCardvalue(scratchCard));
        }
        return values;
    }

    private Integer computeCardvalue(ScratchCard scratchCard) {
        int cardvalue = 1;
        for (int winningNumber : scratchCard.getWinningNumbers()) {
            if (scratchCard.getNumbersYouHave().contains(winningNumber)) {
                cardvalue *= 2;
            }
        }
        return cardvalue == 1 ? 0 : cardvalue / 2;
    }
}
