package com.antcer00.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class Utils {

    private Utils() {}

    public static List<String> getLines(String inputPath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static double sumValues(Collection<? extends Number>... collections) {
        return Arrays.stream(collections)
                .flatMap(Collection::stream)
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}