package org.example.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static org.example.day2.CubeColor.getCubeColorFromValue;

public class Day2 {

    private static final String INPUT_PATH = "src/main/resources/input/day2/input.txt";

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

    protected List<Game> populateGames(List<String> lines) {
        List<Game> games = new ArrayList<>();
        for (String line : lines) {
            games.add(populateGame(line));
        }
        return games;
    }

    private Game populateGame(String line) {
        Game game = new Game();
        String gameNumberAsString = line.split(":")[0].split(" ")[1];
        game.setGameNumber(parseInt(gameNumberAsString));
        game.setExtractionsList(popoulateExtractionsList(line.split(":")[1]));
        return game;
    }

    private List<Set<CubeExtraction>> popoulateExtractionsList(String line) {
        List<Set<CubeExtraction>> extractionsList = new ArrayList<>();
        String[] extractionsSet = line.split(";");
        for (String extractions : extractionsSet) {
            extractionsList.add(populateExtractions(extractions));
        }
        return extractionsList;
    }

    private Set<CubeExtraction> populateExtractions(String line) {
        Set<CubeExtraction> extractions = new HashSet<>();
        String[] extractionsAsString = line.split(",");
        for (String extractionAsString : extractionsAsString) {
            extractions.add(populateExtraction(extractionAsString));
        }
        return extractions;
    }

    private CubeExtraction populateExtraction(String line) {
        line = line.trim();
        return new CubeExtraction(
                getCubeColorFromValue(line.split(" ")[1]),
                Integer.parseInt(line.split(" ")[0])
        );
    }

}
