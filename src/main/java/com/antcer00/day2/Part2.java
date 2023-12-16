package com.antcer00.day2;

import java.util.List;
import java.util.Set;

public class Part2 extends Day2 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<Game> games = part2.populateGames(lines);
        int sum = 0;
        for (Game game : games) {
            sum += part2.calculatePowerOfMinCubes(game);
        }
        System.out.println(sum);
    }

    private int calculatePowerOfMinCubes(Game game) {
        CubeExtraction minRed = findMinCubesByColor(game, CubeColor.RED);
        CubeExtraction minGreen = findMinCubesByColor(game, CubeColor.GREEN);
        CubeExtraction minBlue = findMinCubesByColor(game, CubeColor.BLUE);
        return powerOfCubes(minRed, minGreen, minBlue);
    }

    private CubeExtraction findMinCubesByColor(Game game, CubeColor color) {
        CubeExtraction minExtraction = new CubeExtraction(color, 0);

        for (Set<CubeExtraction> extractionsSet : game.getExtractionsList()) {
            for (CubeExtraction extraction : extractionsSet) {
                if (extraction.getColor() == color && extraction.getNumberOfCubes() > minExtraction.getNumberOfCubes()) {
                    minExtraction.setNumberOfCubes(extraction.getNumberOfCubes());
                }
            }
        }

        return minExtraction;
    }

    private int powerOfCubes(CubeExtraction e1, CubeExtraction e2, CubeExtraction e3) {
        if (e1.getColor() != CubeColor.RED && e2.getColor() != CubeColor.GREEN && e3.getColor() != CubeColor.BLUE) {
            throw new RuntimeException("The 3 extractions must be of different colors. Namely RED, GREEN, BLUE");
        }
        return e1.getNumberOfCubes() * e2.getNumberOfCubes() * e3.getNumberOfCubes();
    }
}
