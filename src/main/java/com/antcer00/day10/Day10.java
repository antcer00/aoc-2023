package com.antcer00.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day9 {

    protected static final String INPUT_PATH = "src/main/resources/input/day9/input.txt";

    protected int getResult(List<List<Integer>> originalSquences) {
        int result = 0;
        for (List<Integer> originalSequence : originalSquences) {
            List<List<Integer>> values = computeSequences(originalSequence);
            result += computeNextValue(values);
        }
        return result;
    }

    private int computeNextValue(List<List<Integer>> values) {
        for (int i = values.size() - 1; i >= 0; i--) {
            List<Integer> list = values.get(i);
            if (i == values.size() - 1) {
                list.add(0);
            } else {
                int nextValue = list.get(list.size() - 1) + values.get(i + 1).get(values.get(i + 1).size() - 1);
                list.add(nextValue);
            }
        }
        return values.get(0).get(values.get(0).size() - 1);
    }

    private List<List<Integer>> computeSequences(List<Integer> originalSequence) {
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> nextSequence = new ArrayList<>(originalSequence);
        sequences.add(nextSequence);
        while (!isZero(nextSequence)) {
            nextSequence = getNextSequence(nextSequence);
            sequences.add(nextSequence);
        }
        return sequences;
    }

    private List<Integer> getNextSequence(List<Integer> sequence) {
        List<Integer> nextSequence = new ArrayList<>();
        for (int i = 0; i < sequence.size() - 1; i++) {
            nextSequence.add(sequence.get(i + 1) - sequence.get(i));
        }
        return nextSequence;
    }

    private boolean isZero(List<Integer> sequence) {
        for (int i : sequence) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    protected List<List<Integer>> parseInput(List<String> lines) {
        List<List<Integer>> values = new ArrayList<>();
        for (String line : lines) {
            String[] stringValues = line.split(" ");
            values.add(Arrays.stream(stringValues).map(Integer::parseInt).collect(toList()));
        }
        return values;
    }
}
