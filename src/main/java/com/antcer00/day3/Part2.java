package com.antcer00.day3;

import java.util.*;

public class Part2 extends Day3 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<NumberWithPosition> numbers = part2.getNumbersWithPosition(lines);
        List<SymbolWithPosition> symbols = part2.getSymbolsWithPosition(lines);
        System.out.println(part2.sumGearRatios(numbers, symbols));
    }

    private int sumGearRatios(List<NumberWithPosition> numbers, List<SymbolWithPosition> symbols) {
        int sum = 0;
        for (SymbolWithPosition symbol : symbols) {
            int gearRatio = 0;
            if ((gearRatio = getRatioIfGear(symbol, numbers)) != -1) {
                sum += gearRatio;
            }
        }
        return sum;
    }

    private int getRatioIfGear(SymbolWithPosition symbol, List<NumberWithPosition> numbers) {
        if (symbol.getSymbol() != '*') {
            return -1;
        }
        Set<Integer> partNumbers = new HashSet<>();
        for (NumberWithPosition number : numbers) {
            if (isNumberNearSymbol(number, symbol)) {
                partNumbers.add(number.getNumber());
            }
        }
        return partNumbers.size() == 2 ? partNumbers.stream().reduce(1, (n1, n2) -> n1 * n2) : -1;
    }
}
