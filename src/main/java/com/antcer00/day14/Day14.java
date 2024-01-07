package com.antcer00.day14;

import java.util.List;
import java.util.stream.Collectors;

public class Day14 {

    protected static final String INPUT_PATH = "src/main/resources/input/day14/input.txt";

    protected List<List<Character>> getMatrix(List<String> lines) {
        return lines.stream()
                .map(line -> line.chars().mapToObj(c -> (char) c).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    protected int computeLoad(List<List<Character>> matrix) {
        int ySize = matrix.size();
        int load = 0;
        for (int yPos = 0; yPos < ySize; yPos++) {
            for (int xPos = 0; xPos < matrix.get(0).size(); xPos++) {
                if (matrix.get(yPos).get(xPos).equals('O')) {
                    load += ySize - yPos;
                }
            }
        }
        return load;
    }

    protected void moveAllRoundStones(List<List<Character>> matrix) {
        for (int yPos = 0; yPos < matrix.size(); yPos++) {
            for (int xPos = 0; xPos < matrix.get(0).size(); xPos++) {
                if (matrix.get(yPos).get(xPos).equals('O')) {
                    moveToNorth(matrix, xPos, yPos);
                }
            }
        }
    }

    private void moveToNorth(List<List<Character>> matrix, int xPos, int yPos) {
        int newYPos = yPos;
        while (newYPos > 0 && matrix.get(newYPos - 1).get(xPos).equals('.') ) {
            newYPos--;
        }
        if (newYPos != yPos) {
            matrix.get(yPos).set(xPos, '.');
            matrix.get(newYPos).set(xPos, 'O');
        }
    }
}