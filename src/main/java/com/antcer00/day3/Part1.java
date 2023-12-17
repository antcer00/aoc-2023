package com.antcer00.day3;

import java.util.List;

public class Part1 extends Day3 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<NumberWithPosition> numbers = part1.getNumbersWithPosition(lines);
        List<SymbolWithPosition> symbols = part1.getSymbolsWithPosition(lines);
        System.out.println(part1.sumPartNumbers(numbers, symbols));
    }

    private int sumPartNumbers(List<NumberWithPosition> numbers, List<SymbolWithPosition> symbols) {
        int accumulator = 0;
        for (NumberWithPosition number : numbers) {
            if (isPartNumber(number, symbols)) {
                accumulator += number.getNumber();
            }
        }
        return accumulator;
    }

}
