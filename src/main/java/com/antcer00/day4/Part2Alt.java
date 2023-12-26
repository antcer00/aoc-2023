package com.antcer00.day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2Alt extends Day4 {

    public static void main(String[] args) {
        Part2Alt part2 = new Part2Alt();
        List<String> lines = part2.getLines();
        List<ScratchCard> scratchCards = part2.getCards(lines);
        Map<ScratchCard, Integer> copiesPerCard = part2.initCopiesAlt(scratchCards);
        Map<ScratchCard, Integer> copiesPerCardPreviousIteration = new HashMap<>();
        int index = 1;
        do {
            copiesPerCardPreviousIteration.clear();
            copiesPerCardPreviousIteration.putAll(copiesPerCard);
            part2.computeCopiesForEachCardAlt(copiesPerCard, index);
//            index = part2.computeNewIndex(copiesPerCard);
        } while (!part2.areEquals(copiesPerCard, copiesPerCardPreviousIteration));
        System.out.println(part2.sumValues(copiesPerCard));
    }

    private boolean areEquals(Map<ScratchCard, Integer> copiesPerCard, Map<ScratchCard, Integer> copiesPerCardPreviousIteration) {
        for (ScratchCard scratchCard : copiesPerCard.keySet()) {
            if (copiesPerCardPreviousIteration.get(scratchCard) != copiesPerCard.get(scratchCard)) {
                return false;
            }
        }
        return true;
    }

    private int computeNewIndex(Map<ScratchCard, Integer> copiesPerCard) {
        Map<ScratchCard, Integer> copiesToElaborate = new HashMap<>();
        int minValue = Collections.min(copiesPerCard.values());
        for (Map.Entry<ScratchCard, Integer> entry : copiesPerCard.entrySet()) {
            if (entry.getValue() > minValue) {
                copiesToElaborate.put(entry.getKey(), entry.getValue());
            }
        }
        return Collections.min(copiesToElaborate.values());
    }

    private void computeCopiesForEachCardAlt(Map<ScratchCard, Integer> copiesPerCard, int depthLevel) {
        for (ScratchCard scratchCard : copiesPerCard.keySet()) {
            if (copiesPerCard.get(scratchCard) < depthLevel) {
                continue;
            }
            int matchingNumbers = getMatchingNumbers(scratchCard);
            for (int i = scratchCard.getCardId() + 1; i <= scratchCard.getCardId() + matchingNumbers; i++) {
                int finalI1 = i;
                copiesPerCard.merge(copiesPerCard.keySet().stream().filter(c -> c.getCardId() == finalI1).findFirst().get(), 1, Integer::sum);
            }
        }
    }

    private Map<ScratchCard, Integer> initCopiesAlt(List<ScratchCard> scratchCards) {
        Map<ScratchCard, Integer> copiesPerCard = new HashMap<>();
        for (ScratchCard scratchCard : scratchCards) {
            copiesPerCard.put(scratchCard, 1);
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
