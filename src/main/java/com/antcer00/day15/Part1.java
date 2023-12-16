package com.antcer00.day15;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Day15 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<String> stringValues = part1.parseValues(lines.get(0));
        List<Integer> integers = part1.hashStrings(stringValues);
        System.out.println(part1.sumIntegers(integers));
    }

    protected List<Integer> hashStrings(List<String> strings) {
        List<Integer> hashValues = new ArrayList<>();
        for (String string : strings) {
            hashValues.add(hashString(string));
        }
        return hashValues;
    }
}
