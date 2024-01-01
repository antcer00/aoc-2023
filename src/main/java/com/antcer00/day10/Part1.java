package com.antcer00.day9;

import com.antcer00.utils.Utils;

import java.util.List;

public class Part1 extends Day9 {
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = Utils.getLines(INPUT_PATH);
        List<List<Integer>> originalSquences = part1.parseInput(lines);
        System.out.println(part1.getResult(originalSquences));
    }
}
