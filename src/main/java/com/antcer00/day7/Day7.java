package com.antcer00.day7;

import com.antcer00.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Day7 {
    protected static final String INPUT_PATH = "src/main/resources/input/day7/input.txt";

    protected static int computeTotalWinnings(List<Hand> hands) {
        int rank = 1;
        int totalWinnings = 0;
        for (Hand hand : hands) {
            totalWinnings += rank++ * hand.getBet();
        }
        return totalWinnings;
    }

    protected List<Hand> getHands(List<String> lines) {
        List<Hand> hands = new ArrayList<>();
        for (String line : lines) {
            hands.add(new Hand(getCards(line.split(" ")[0]), parseInt(line.split(" ")[1])));
        }
        return hands;
    }

    private List<Card> getCards(String cardsString) {
        List<Card> cards = new ArrayList<>();
        for (char c : cardsString.toCharArray()) {
            cards.add(Card.getCard(c));
        }
        return cards;
    }

}
