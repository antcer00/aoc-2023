package com.antcer00.day11;

import com.antcer00.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.antcer00.utils.Utils.sumValues;

public class Part1 extends Day11 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = Utils.getLines(INPUT_PATH);
        List<List<Point>> universe = part1.initUniverse(lines);
        part1.expandUniverse(universe);
        Set<Point> galaxies = part1.getGalaxies(universe);
        Set<Pair> pairs = part1.getPairs(galaxies);
        List<Integer> distances = part1.computeDistances(pairs);
        System.out.println(sumValues(distances));
    }



    private void expandUniverse(List<List<Point>> universe) {
        for (int yPos = 0; yPos < universe.size(); yPos++) {
            if (isRowEmpty(universe.get(yPos))) {
                universe.add(yPos++, emptyRow(yPos, universe.get(yPos).size()));
            }
        }
        for (int xPos = 0; xPos < universe.get(0).size(); xPos++) {
            if (isColumnEmpty(universe, xPos)) {
                addEmptyColumn(universe, xPos++);
            }
        }
        for (int yPos = 0; yPos < universe.size(); yPos++) {
            for (int xPos = 0; xPos < universe.get(yPos).size(); xPos++) {
                universe.get(yPos).get(xPos).setPositions(xPos, yPos);
            }
        }
    }

    private List<Point> emptyRow(int yPos, int size) {
        List<Point> row = new ArrayList<>();
        for (int xPos = 0; xPos < size; xPos++) {
            row.add(new Point('.', xPos, yPos));
        }
        return row;
    }

    private void addEmptyColumn(List<List<Point>> universe, int xPos) {
        for (int yPos = 0; yPos < universe.size(); yPos++) {
            universe.get(yPos).add(xPos, new Point('.', xPos, yPos));
        }
    }
}
