package com.antcer00.day14;

import com.antcer00.utils.Utils;

import java.util.List;

public class Part1 extends Day14 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = Utils.getLines(INPUT_PATH);
        List<List<Character>> matrix = part1.getMatrix(lines);
        part1.moveAllRoundStones(matrix);
        System.out.println(part1.computeLoad(matrix));
    }
}
