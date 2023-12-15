package org.example.day2;

import java.util.List;
import java.util.Set;

import static org.example.day2.CubeColor.*;

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
        CubeExtraction minRed = findMinCubesByColor(game, RED);
        CubeExtraction minGreen = findMinCubesByColor(game, GREEN);
        CubeExtraction minBlue = findMinCubesByColor(game, BLUE);
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
        if (e1.getColor() != RED && e2.getColor() != GREEN && e3.getColor() != BLUE) {
            throw new RuntimeException("The 3 extractions must be of different colors. Namely RED, GREEN, BLUE");
        }
        return e1.getNumberOfCubes() * e2.getNumberOfCubes() * e3.getNumberOfCubes();
    }
}
