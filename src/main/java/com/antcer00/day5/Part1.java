package com.antcer00.day5;

import java.util.List;

public class Part1 extends Day5 {
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<Long> seedNumbers = part1.getSeedNumbers(lines.get(0));
        List<CategoryMap<Category, Category>> categoryMaps = part1.getCategoryMaps(lines);
        List<Long> locations = part1.findLocations(categoryMaps, seedNumbers);
        System.out.println(locations.stream().min(Long::compareTo).get());
    }

}
