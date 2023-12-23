package com.antcer00.day4;

import java.util.*;

public class Part2 extends Day4 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<Card> cards = part2.getCards(lines);
        Map<Integer, Integer> copiesPerCard = part2.initCopies(cards);
        int i = 0;
        while (!cards.isEmpty()) {
            i++;
            System.out.println("Size of cards List: " + cards.size());
            long startTime = System.nanoTime();
            part2.computeCopiesForEachCard(cards, copiesPerCard);
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("Total execution time iternation n." + i + " : " + elapsedTime / 1000000 + "ms");
        }
        System.out.println(part2.sumValues(copiesPerCard));
    }



    private void computeCopiesForEachCard(List<Card> cards, Map<Integer, Integer> copiesPerCard) {
        List<Card> newCards = new ArrayList<>();
        for (Card card : cards) {
            int matchingNumbers = getMatchingNumbers(card);
            for (int i = card.getCardId() + 1; i <= card.getCardId() + matchingNumbers; i++) {
                copiesPerCard.replace(i, copiesPerCard.get(i) + 1);
                int finalI = i;
                newCards.add(cards.stream().filter(c -> c.getCardId() == finalI).findFirst().get());
            }
        }
        cards.clear();
        cards.addAll(newCards);
    }



    private Map<Integer, Integer> initCopies(List<Card> cards) {
        Map<Integer, Integer> copiesPerCard = new HashMap<>();
        for (Card card : cards) {
            copiesPerCard.put(card.getCardId(), 1);
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
