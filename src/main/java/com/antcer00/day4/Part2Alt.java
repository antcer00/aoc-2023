package com.antcer00.day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2Alt extends Day4 {

    public static void main(String[] args) {
        Part2Alt part2 = new Part2Alt();
        List<String> lines = part2.getLines();
        List<Card> cards = part2.getCards(lines);
        Map<Card, Integer> copiesPerCard = part2.initCopiesAlt(cards);
        Map<Card, Integer> copiesPerCardPreviousIteration = new HashMap<>();
        int index = 1;
        do {
            copiesPerCardPreviousIteration.clear();
            copiesPerCardPreviousIteration.putAll(copiesPerCard);
            part2.computeCopiesForEachCardAlt(copiesPerCard, index);
//            index = part2.computeNewIndex(copiesPerCard);
        } while (!part2.areEquals(copiesPerCard, copiesPerCardPreviousIteration));
        System.out.println(part2.sumValues(copiesPerCard));
    }

    private boolean areEquals(Map<Card, Integer> copiesPerCard, Map<Card, Integer> copiesPerCardPreviousIteration) {
        for (Card card : copiesPerCard.keySet()) {
            if (copiesPerCardPreviousIteration.get(card) != copiesPerCard.get(card)) {
                return false;
            }
        }
        return true;
    }

    private int computeNewIndex(Map<Card, Integer> copiesPerCard) {
        Map<Card, Integer> copiesToElaborate = new HashMap<>();
        int minValue = Collections.min(copiesPerCard.values());
        for (Map.Entry<Card, Integer> entry : copiesPerCard.entrySet()) {
            if (entry.getValue() > minValue) {
                copiesToElaborate.put(entry.getKey(), entry.getValue());
            }
        }
        return Collections.min(copiesToElaborate.values());
    }

    private void computeCopiesForEachCardAlt(Map<Card, Integer> copiesPerCard, int depthLevel) {
        for (Card card : copiesPerCard.keySet()) {
            if (copiesPerCard.get(card) < depthLevel) {
                continue;
            }
            int matchingNumbers = getMatchingNumbers(card);
            for (int i = card.getCardId() + 1; i <= card.getCardId() + matchingNumbers; i++) {
                int finalI1 = i;
                copiesPerCard.merge(copiesPerCard.keySet().stream().filter(c -> c.getCardId() == finalI1).findFirst().get(), 1, Integer::sum);
            }
        }
    }

    private Map<Card, Integer> initCopiesAlt(List<Card> cards) {
        Map<Card, Integer> copiesPerCard = new HashMap<>();
        for (Card card : cards) {
            copiesPerCard.put(card, 1);
        }
        return copiesPerCard;
    }

    private int getMatchingNumbers(Card card) {
        int matches = 0;
        for (int winningNumber : card.getWinningNumbers()) {
            if (card.getNumbersYouHave().contains(winningNumber)) {
                matches++;
            }
        }
        return matches;
    }


}
