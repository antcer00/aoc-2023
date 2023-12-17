package com.antcer00.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        List<String> lines = day4.getLines();
        List<Card> cards = day4.getCards(lines);
        List<Integer> cardValues = day4.getCardValues(cards);
        System.out.println(day4.sumValues(cardValues));
    }

    private static final String INPUT_PATH = "src/main/resources/input/day4/input.txt";

    protected List<String> getLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    protected List<Card> getCards(List<String> lines) {
        List<Card> cards = new ArrayList<>();
        for (String line : lines) {
            Card card = new Card();
            card.setWinningNumbers(
                    Arrays.stream(line.split(":")[1].split("\\|")[0].trim().split("\\s+"))
                            .map(Integer::valueOf)
                            .collect(Collectors.toSet())
            );
            card.setNumbersYouHave(
                    Arrays.stream(line.split(":")[1].split("\\|")[1].trim().split("\\s+"))
                            .map(Integer::valueOf)
                            .collect(Collectors.toSet())
            );
            cards.add(card);
        }
        return cards;
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

    private int sumValues(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }

}
