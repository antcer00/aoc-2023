package com.antcer00.day1;

import java.util.List;

import static java.lang.Character.isDigit;

public class Part1 extends Day1 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<Integer> numbers = part1.getNumbersFromLines(lines);
        int sum = part1.sumIntegers(numbers);
        System.out.println(sum);
    }

    protected int getFirstAndLastDigit(String line) {
        char firstDigit = '0';
        char lastDigit = '0';
        for (int i = 0; i < line.length(); i++) {
            if (isDigit(line.charAt(i))) {
                firstDigit = line.charAt(i);
                break;
            }
        }

        for (int i = line.length() - 1; i >= 0; i--) {
            if (isDigit(line.charAt(i))) {
                lastDigit = line.charAt(i);
                break;
            }
        }
        String numberAsString = Character.toString(firstDigit) + Character.toString(lastDigit);
        return Integer.parseInt(numberAsString);
    }
}
