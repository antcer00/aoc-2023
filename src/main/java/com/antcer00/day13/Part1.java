package com.antcer00.day13;

import com.antcer00.utils.Utils;

import java.util.List;
import java.util.Set;

public class Part1 extends Day13 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = Utils.getLines(INPUT_PATH);
        Set<List<List<Character>>> matrixes = part1.getMatrixes(lines);
        System.out.println(part1.getResult(matrixes));
    }
}
