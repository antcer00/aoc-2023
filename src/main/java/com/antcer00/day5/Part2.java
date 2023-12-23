package com.antcer00.day5;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Long.min;
import static java.lang.Long.parseLong;

public class Part2 extends Day5 {
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<CategoryMap<Category, Category>> categoryMaps = part2.getCategoryMaps(lines);
        long minLocation = part2.getActualSeedNumbers(lines.get(0), categoryMaps);
        System.out.println(minLocation);
    }

    private long getActualSeedNumbers(String line, List<CategoryMap<Category, Category>> categoryMaps) {
        long minValue = Long.MAX_VALUE;
        String[] seedNumbers = line.split(":")[1].trim().split(" ");
        for (int i = 0; i < seedNumbers.length; i = i + 2) {
            long location = getMinValueForInterval(parseLong(seedNumbers[i]), parseLong(seedNumbers[i + 1]), categoryMaps);
            if (location < minValue) {
                minValue = location;
            }
        }
        return minValue;
    }

    private long getMinValueForInterval(long startValue, long intervalLength, List<CategoryMap<Category, Category>> categoryMaps) {
        long minValue = Long.MAX_VALUE;
        for (long i = startValue; i < startValue + intervalLength; i++) {
            long location = findLocation(i, categoryMaps);
            if (location < minValue) {
                minValue = location;
            }
        }
        return minValue;
    }

}
