package com.antcer00.day7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

import static com.antcer00.day7.Type.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hand implements Comparable<Hand> {
    private List<Card> cards = new ArrayList<>(5);

    private int bet;

    public Type getType() {
        Map<Card, Integer> cardsFrequency = cardsFrequency(cards);
        Map.Entry<Card, Integer> mostFrequentCard = Collections.max(cardsFrequency.entrySet(), Map.Entry.comparingByValue());
        Map.Entry<Card, Integer> secondMostFrequentCard;
        switch (mostFrequentCard.getValue()) {
            case 5:
                return FIVE_OF_A_KIND;
            case 4:
                return FOUR_OF_A_KIND;
            case 3:
                cardsFrequency.remove(mostFrequentCard.getKey());
                secondMostFrequentCard = Collections.max(cardsFrequency.entrySet(), Map.Entry.comparingByValue());
                return secondMostFrequentCard.getValue() == 2 ? FULL_HOUSE : THREE_OF_A_KIND;
            case 2:
                cardsFrequency.remove(mostFrequentCard.getKey());
                secondMostFrequentCard = Collections.max(cardsFrequency.entrySet(), Map.Entry.comparingByValue());
                return secondMostFrequentCard.getValue() == 2 ? TWO_PAIR : ONE_PAIR;
            default:
                return HIGH_CARD;
        }
    }


    private static Map<Card, Integer> cardsFrequency(List<Card> cards) {
        Map<Card, Integer> frequencyMap = new HashMap<>();
        for (Card card : cards) {
            frequencyMap.put(card, frequencyMap.getOrDefault(card, 0) + 1);
        }
        return frequencyMap;
    }

    @Override
    public int compareTo(Hand hand) {
        if (hand.getType().rank < this.getType().rank) {
            return -1;
        } else if (hand.getType().rank > this.getType().rank) {
            return 1;
        }
        for (int i = 0; i < 5; i++) {
            if (cards.get(i).rank < hand.getCards().get(i).rank) {
                return 1;
            } else if (cards.get(i).rank > hand.getCards().get(i).rank) {
                return -1;
            }
        }
        return 0;
    }
}
