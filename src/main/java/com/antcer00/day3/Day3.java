package com.antcer00.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Day3 {

    public static void main(String[] args) {
        Day3 day3 = new Day3();
        List<String> lines = day3.getLines();
        List<NumberWithPosition> numbers = day3.getNumbersWithPosition(lines);
        List<SymbolWithPosition> symbols = day3.getSymbolsWithPosition(lines);
        System.out.println(day3.sumNumbersNearSumbols(numbers, symbols));
    }

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

    private List<NumberWithPosition> getNumbersWithPosition(List<String> lines) {
        List<NumberWithPosition> numbers = new ArrayList<>();
        String numberAsString = "";
        for (int posY = 0; posY < lines.size(); posY++) {
            for (int posX = 0; posX < lines.get(posY).length(); posX++) {
                char character = lines.get(posY).charAt(posX);
                if (Character.isDigit(character)) {
                    numberAsString += String.valueOf(character);
                    if (posX == lines.get(posY).length() - 1) {
                        if (isEmpty(numberAsString))
                            continue;
                        numberAsString = addNumberAndReset(numbers, numberAsString, posY, posX);
                    }
                } else {
                    if (isEmpty(numberAsString))
                        continue;
                    numberAsString = addNumberAndReset(numbers, numberAsString, posY, posX);
                }
            }
        }
        return numbers;
    }

    private static boolean isEmpty(String numberAsString) {
        return numberAsString.isEmpty();
    }

    private static String addNumberAndReset(List<NumberWithPosition> numbers, String numberAsString, int posY, int posX) {
        Coordinate startPos = new Coordinate(posX - numberAsString.length(), posY);
        Coordinate endPos = new Coordinate(posX - 1, posY);
        numbers.add(new NumberWithPosition(Integer.valueOf(numberAsString), startPos, endPos));
        numberAsString = "";
        return numberAsString;
    }

    private List<SymbolWithPosition> getSymbolsWithPosition(List<String> lines) {
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

    private boolean isNumberNearASymbol(NumberWithPosition number, List<SymbolWithPosition> symbols) {
        for (SymbolWithPosition symbol : symbols) {
            if (areCoordinateWithinRange(symbol.getPos(), number.getStartPos()) || areCoordinateWithinRange(symbol.getPos(), number.getEndPos())) {
                return true;
            }
        }
        return false;
    }

    private boolean areCoordinateWithinRange(Coordinate c1, Coordinate c2) {
        int distanceX = c1.getPosX() - c2.getPosX();
        int distanceY = c1.getPosY() - c2.getPosY();
        int distance = (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        if (distance <= 1) {
            return true;
        }
        return false;
    }

    private int sumNumbersNearSumbols(List<NumberWithPosition> numbers, List<SymbolWithPosition> symbols) {
        int accumulator = 0;
        for (NumberWithPosition number : numbers) {
            if (isNumberNearASymbol(number, symbols)) {
                accumulator += number.getNumber();
            }
        }
        return accumulator;
    }

    private boolean isSymbol(char c) {
        return AVAILABLE_SYMBOLS.contains(c);
    }
}
