package com.antcer00.day1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;

public class Part2 extends Day1 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<Integer> numbers = part2.getNumbersFromLines(lines);
        int sum = part2.sumIntegers(numbers);
        System.out.println(sum);
    }

    protected int getFirstAndLastDigit(String line) {
        List<DigitWithPosition> digitWithPositions = new ArrayList<>();
        digitWithPositions.add(getPositionFirstNumericDigit(line));
        digitWithPositions.add(getPositionLastNumericDigit(line));
        digitWithPositions.add(getPositionFirstStringDigit(line));
        digitWithPositions.add(getPositionLastStringDigit(line));
        digitWithPositions = digitWithPositions.stream()
                .filter(d -> d.getPosition() != -1)
                .collect(Collectors.toList());

        Integer firstDigit = digitWithPositions.stream()
                .min((d1, d2) -> d1.getPosition() - d2.getPosition())
                .get()
                .getDigit();
        Integer lastDigit = digitWithPositions.stream()
                .max((d1, d2) -> d1.getPosition() - d2.getPosition())
                .get()
                .getDigit();

        return Integer.valueOf(firstDigit.toString() + lastDigit.toString());
    }


    private DigitWithPosition getPositionFirstStringDigit(String line) {
        Set<DigitWithPosition> digitWithposition = new HashSet<>();
        for (Digit digit : Digit.values()) {
            int digitPosition = 0;
            if ((digitPosition = line.indexOf(digit.label)) >= 0) {
                digitWithposition.add(new DigitWithPosition(digit.numericValue, digitPosition));
            }
        }
        return digitWithposition.stream()
                .min((d1, d2) -> d1.getPosition() - d2.getPosition())
                .orElse(new DigitWithPosition());
    }

    private DigitWithPosition getPositionLastStringDigit(String line) {
        Set<DigitWithPosition> digitWithposition = new HashSet<>();
        for (Digit digit : Digit.values()) {
            int digitPosition = 0;
            if ((digitPosition = line.lastIndexOf(digit.label)) >= 0) {
                digitWithposition.add(new DigitWithPosition(digit.numericValue, digitPosition));
            }
        }
        return digitWithposition.stream()
                .max((d1, d2) -> d1.getPosition() - d2.getPosition())
                .orElse(new DigitWithPosition());
    }


    private DigitWithPosition getPositionFirstNumericDigit(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (isDigit(line.charAt(i))) {
                return new DigitWithPosition(Character.getNumericValue(line.charAt(i)), i);
            }
        }
        return new DigitWithPosition();
    }

    private DigitWithPosition getPositionLastNumericDigit(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            if (isDigit(line.charAt(i))) {
                return new DigitWithPosition(Character.getNumericValue(line.charAt(i)), i);
            }
        }
        return new DigitWithPosition();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    private static class DigitWithPosition {
        int digit = 0;
        int position = -1;
    }

}
