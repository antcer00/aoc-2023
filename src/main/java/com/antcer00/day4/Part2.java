package com.antcer00.day4;

import java.util.*;

public class Part2 extends Day4 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<ScratchCard> scratchCards = part2.getCards(lines);
        Map<Integer, Integer> copiesPerCard = part2.initCopies(scratchCards);
        while (!scratchCards.isEmpty()) {
            System.out.println("Size of cards List: " + scratchCards.size());
            part2.computeCopiesForEachCard(scratchCards, copiesPerCard);
        }
        System.out.println(part2.sumValues(copiesPerCard));
    }



    private void computeCopiesForEachCard(List<ScratchCard> scratchCards, Map<Integer, Integer> copiesPerCard) {
        List<ScratchCard> newScratchCards = new ArrayList<>();
        for (ScratchCard scratchCard : scratchCards) {
            int matchingNumbers = getMatchingNumbers(scratchCard);
            for (int i = scratchCard.getCardId() + 1; i <= scratchCard.getCardId() + matchingNumbers; i++) {
                copiesPerCard.replace(i, copiesPerCard.get(i) + 1);
                int finalI = i;
                newScratchCards.add(scratchCards.stream().filter(c -> c.getCardId() == finalI).findFirst().get());
            }
        }
        scratchCards.clear();
        scratchCards.addAll(newScratchCards);
    }



    private Map<Integer, Integer> initCopies(List<ScratchCard> scratchCards) {
        Map<Integer, Integer> copiesPerCard = new HashMap<>();
        for (ScratchCard scratchCard : scratchCards) {
            copiesPerCard.put(scratchCard.getCardId(), 1);
        }
        return copiesPerCard;
    }



    private int getMatchingNumbers(ScratchCard scratchCard) {
        int matches = 0;
        for (int winningNumber : scratchCard.getWinningNumbers()) {
            if (scratchCard.getNumbersYouHave().contains(winningNumber)) {
                matches++;
            }
        }
        return matches;
    }
}
