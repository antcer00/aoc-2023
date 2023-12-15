package org.example.day2;

import java.util.*;
import java.util.List;


import static org.example.day2.CubeColor.*;

public class Part1 extends Day2 {

    private static final Map<CubeColor, Integer> BAG = new HashMap<>();

    static {
        BAG.put(RED, 12);
        BAG.put(GREEN, 13);
        BAG.put(BLUE, 14);
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<Game> games = part1.populateGames(lines);
        List<Game> possibleGames = getPossibleGames(games);
        System.out.println(sumGameNumbers(possibleGames));
    }

    private static List<Game> getPossibleGames(List<Game> games) {
        List<Game> possibleGames = new ArrayList<>();
        for (Game game : games) {
            if (isGamePossible(game)) {
                possibleGames.add(game);
            }
        }
        return possibleGames;
    }

    private static boolean isGamePossible(Game game) {
        for (Set<CubeExtraction> extractions : game.getExtractionsList()) {
            for (CubeExtraction extraction : extractions) {
                if (!isExtractionPossible(extraction)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isExtractionPossible(CubeExtraction extraction) {
        int availableCubes = BAG.get(extraction.getColor());
        int numberOfCubesToExtract = extraction.getNumberOfCubes();
        return numberOfCubesToExtract <= availableCubes;
    }

    private static int sumGameNumbers(List<Game> games) {
        return games.stream().mapToInt(Game::getGameNumber).sum();
    }
}
