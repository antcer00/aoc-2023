package com.antcer00.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Day4 {

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

    protected List<ScratchCard> getCards(List<String> lines) {
        List<ScratchCard> scratchCards = new ArrayList<>();
        for (String line : lines) {
            ScratchCard scratchCard = new ScratchCard();
            scratchCard.setCardId(parseInt(line.split(":")[0].split("\\s+")[1]));
            scratchCard.setWinningNumbers(
                    Arrays.stream(line.split(":")[1].split("\\|")[0].trim().split("\\s+"))
                            .map(Integer::valueOf)
                            .collect(Collectors.toSet())
            );
            scratchCard.setNumbersYouHave(
                    Arrays.stream(line.split(":")[1].split("\\|")[1].trim().split("\\s+"))
                            .map(Integer::valueOf)
                            .collect(Collectors.toSet())
            );
            scratchCards.add(scratchCard);
        }
        return scratchCards;
    }

    protected int sumValues(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }

    protected int sumValues(Map<?, Integer> map) {
        return map.values().stream().reduce(0, Integer::sum);
    }



}
