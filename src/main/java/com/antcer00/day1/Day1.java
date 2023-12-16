package com.antcer00.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public abstract class Day1 {

    protected List<String> getLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/day1/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    protected List<Integer> getNumbersFromLines(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();
        for (String line : lines) {
            int number = getFirstAndLastDigit(line);
            numbers.add(number);
        }
        return numbers;
    }

    protected int sumIntegers(Collection<Integer> integersToSum) {
        return integersToSum.stream().reduce(0, (a, b) -> a + b);
    }

    protected abstract int getFirstAndLastDigit(String line);
}
