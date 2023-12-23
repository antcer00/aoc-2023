package com.antcer00.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

public class Day5 {

    private static final String INPUT_PATH = "src/main/resources/input/day5/input.txt";

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

    protected Set<Long> findLocations(List<CategoryMap<Category, Category>> categoryMaps, Set<Long> seedNumbers) {
        Set<Long> locations = new HashSet<>();
        for (long seedNumber : seedNumbers) {
            locations.add(findLocation(seedNumber, categoryMaps));
        }
        return locations;
    }

    protected long findLocation(long seedNumber, List<CategoryMap<Category, Category>> categoryMaps) {
        long valueForNextMap = seedNumber;
        for (CategoryMap<Category, Category> categoryMap : categoryMaps) {
            for (Interval interval : categoryMap.getIntervals()) {
                if (interval.isValueInSource(valueForNextMap)) {
                    valueForNextMap = interval.getDestination(valueForNextMap);
                    break;
                }
            }
        }
        return valueForNextMap;
    }

    protected Set<Long> getSeedNumbers(String line) {
        String[] seedNumbers = line.split(":")[1].trim().split(" ");
        return Arrays.stream(seedNumbers)
                .map(Long::valueOf)
                .collect(Collectors.toSet());
    }

    protected List<CategoryMap<Category, Category>> getCategoryMaps(List<String> lines) {
        List<CategoryMap<Category, Category>> categoryMaps = new ArrayList<>();
        CategoryMap<Category, Category> categoryMapToParse = new CategoryMap<>();
        for (String line : lines) {
            if (line.contains("seeds:")) {
                continue;
            }
            if (line.isEmpty()) {
                categoryMaps.add(categoryMapToParse.copyOf());
                categoryMapToParse.clear();
            }
            if (line.contains("map")) {
                categoryMapToParse.setSource(Category.getCategory(line.split("-")[0]));
                categoryMapToParse.setDestination(Category.getCategory(line.split("-")[2].split(" ")[0]));
                continue;
            }
            Interval interval = getInterval(line);
            if (!interval.isEmpty()) {
                categoryMapToParse.getIntervals().add(interval);
            }
        }
        categoryMaps.add(categoryMapToParse.copyOf());
        categoryMaps.removeIf(CategoryMap::isEmpty);
        return categoryMaps;
    }

    private Interval getInterval(String line) {
        if (line.isEmpty()) {
            return new Interval();
        }
        return new Interval(
                parseLong(line.split(" ")[1]),
                parseLong(line.split(" ")[0]),
                parseLong(line.split(" ")[2]));
    }

}
