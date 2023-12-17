package com.antcer00.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Day3 {

    private static final String INPUT_PATH = "src/main/resources/input/day3/input.txt";

    private static final Set<Character> AVAILABLE_SYMBOLS = Set.of(
            '#', '$', '%', '&', '*', '+', '-', '/', '=', '@'
    );

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

    protected List<NumberWithPosition> getNumbersWithPosition(List<String> lines) {
        List<NumberWithPosition> numbers = new ArrayList<>();
        String numberAsString = "";
        for (int posY = 0; posY < lines.size(); posY++) {
            for (int posX = 0; posX < lines.get(posY).length(); posX++) {
                char character = lines.get(posY).charAt(posX);
                if (Character.isDigit(character)) {
                    numberAsString += String.valueOf(character);
                    if (posX == lines.get(posY).length() - 1) {
                        if (numberAsString.isEmpty())
                            continue;
                        numberAsString = addNumberAndReset(numbers, numberAsString, posY, posX);
                    }
                } else {
                    if (numberAsString.isEmpty())
                        continue;
                    numberAsString = addNumberAndReset(numbers, numberAsString, posY, posX);
                }
            }
        }
        return numbers;
    }

    private static String addNumberAndReset(List<NumberWithPosition> numbers, String numberAsString, int posY, int posX) {
        Coordinate startPos = new Coordinate(posX - numberAsString.length(), posY);
        Coordinate endPos = new Coordinate(posX - 1, posY);
        numbers.add(new NumberWithPosition(Integer.valueOf(numberAsString), startPos, endPos));
        numberAsString = "";
        return numberAsString;
    }

    protected List<SymbolWithPosition> getSymbolsWithPosition(List<String> lines) {
        List<SymbolWithPosition> symbols = new ArrayList<>();
        for (int posY = 0; posY < lines.size(); posY++) {
            for (int posX = 0; posX < lines.get(posY).length(); posX++) {
                if (isSymbol(lines.get(posY).charAt(posX))) {
                    symbols.add(new SymbolWithPosition(lines.get(posY).charAt(posX), new Coordinate(posX, posY)));
                }
            }
        }
        return symbols;
    }

    protected boolean isPartNumber(NumberWithPosition number, List<SymbolWithPosition> symbols) {
        for (SymbolWithPosition symbol : symbols) {
            if (isNumberNearSymbol(number, symbol)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isNumberNearSymbol(NumberWithPosition number, SymbolWithPosition symbol) {
        return areCoordinatesWithinRange(symbol.getPos(), number.getStartPos()) || areCoordinatesWithinRange(symbol.getPos(), number.getEndPos());
    }

    private boolean areCoordinatesWithinRange(Coordinate c1, Coordinate c2) {
        int distanceX = c1.getPosX() - c2.getPosX();
        int distanceY = c1.getPosY() - c2.getPosY();
        int distance = (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        if (distance <= 1) {
            return true;
        }
        return false;
    }

    protected boolean isSymbol(char c) {
        return AVAILABLE_SYMBOLS.contains(c);
    }
}
