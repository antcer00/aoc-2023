package com.antcer00.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day15 {

    private static final String INPUT_PATH = "src/main/resources/input/day15/input.txt";

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

    protected List<String> parseValues(String line) {
        return List.of(line.split(","));
    }

    protected int hashString(String string) {
        int hashValue = 0;
        for (char character : string.toCharArray()) {
            hashValue = (hashValue + character) * 17 % 256;
        }
        return hashValue;
    }

    protected int sumIntegers(List<Integer> listToSum) {
        return listToSum.stream().reduce(0, Integer::sum);
    }
}
