package com.antcer00.day9;

import com.antcer00.utils.Utils;

import java.util.Collections;
import java.util.List;

public class Part2 extends Day9 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = Utils.getLines(INPUT_PATH);
        List<List<Integer>> originalSquences = part2.parseInput(lines);
        List<List<Integer>> invertedOriginalSequences = part2.invertSequences(originalSquences);
        System.out.println(part2.getResult(invertedOriginalSequences));
    }

    private List<List<Integer>> invertSequences(List<List<Integer>> originalSquences) {
        for (List<Integer> originalSquence : originalSquences) {
            Collections.reverse(originalSquence);
        }
        return originalSquences;
    }
}
