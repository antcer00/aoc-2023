package com.antcer00.day13;

import java.util.*;

import static com.antcer00.utils.Utils.sumValues;
import static java.util.List.copyOf;

/**
 * xPos and yPos are assigned so that:
 * <p>
 * 0123456789 <- xPos
 * ########## 0
 * ########## 1
 * ########## 2
 * ########## 3
 * ########## 4
 * ^
 * |
 * yPos
 */
public class Day13 {

    protected static final String INPUT_PATH = "src/main/resources/input/day13/input.txt";

    protected Set<List<List<Character>>> getMatrixes(List<String> lines) {
        Set<List<List<Character>>> matrixes = new HashSet<>();
        List<List<Character>> matrix = new ArrayList<>();
        List<Character> row = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                matrixes.add(copyOf(matrix));
                matrix.clear();
            } else {
                for (char c : line.toCharArray()) {
                    row.add(c);
                }
                matrix.add(copyOf(row));
                row.clear();
            }
        }
        return matrixes;
    }

    protected int getResult(Set<List<List<Character>>> matrixes) {
        List<Integer> hReflectionColIndexes = new ArrayList<>();
        List<Integer> vReflectionRowIndexes = new ArrayList<>();
        for (List<List<Character>> matrix : matrixes) {
            int index;
            if ((index = isHorizontallyReflected(matrix)) != -1) {
                hReflectionColIndexes.add(index);
            } else if ((index = isVerticallyReflected(matrix)) != -1) {
                vReflectionRowIndexes.add(index);
            }
        }
        hReflectionColIndexes.replaceAll(integer -> integer * 100);
        return (int) sumValues(hReflectionColIndexes, vReflectionRowIndexes);
    }

    protected int isHorizontallyReflected(List<List<Character>> matrix) {
        for (int yPos = 0; yPos < matrix.size() - 1; yPos++) {
            if (checkHorizontalReflection(matrix, yPos)) {
                return yPos + 1;
            }
        }
        return -1;
    }

    private boolean checkHorizontalReflection(List<List<Character>> matrix, int yPos) {
        int nextTopRow = yPos;
        int nextBottomRow = yPos + 1;
        while (nextTopRow >= 0 && nextBottomRow < matrix.size()) {
            if (!areRowsEqual(matrix, nextTopRow--, nextBottomRow++)) {
                return false;
            }
        }
        return true;
    }

    protected int isVerticallyReflected(List<List<Character>> matrix) {
        for (int xPos = 0; xPos < matrix.get(0).size() - 1; xPos++) {
            if (checkVerticalReflection(matrix, xPos)) {
                return xPos + 1;
            }
        }
        return -1;
    }

    private boolean checkVerticalReflection(List<List<Character>> matrix, int xPos) {
        int nextLeftColumn = xPos;
        int nextRightColumn = xPos + 1;
        while (nextLeftColumn >= 0 && nextRightColumn < matrix.get(0).size()) {
            if (!areColumnsEqual(matrix, nextLeftColumn--, nextRightColumn++)) {
                return false;
            }
        }
        return true;
    }

    private boolean areColumnsEqual(List<List<Character>> matrix, int column1, int column2) {
        for (List<Character> row : matrix) {
            char char1 = row.get(column1);
            char char2 = row.get(column2);
            if (char1 != char2) {
                return false;
            }
        }
        return true;
    }

    private boolean areRowsEqual(List<List<Character>> matrix, int row1, int row2) {
        return matrix.get(row1).equals(matrix.get(row2));
    }

}
