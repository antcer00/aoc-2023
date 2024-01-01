package com.antcer00.day11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day11 {

    protected static final String INPUT_PATH = "src/main/resources/input/day11/input.txt";

    protected static void printUniverse(List<List<Point>> universe) {
        for (List<Point> points : universe) {
            for (Point point : points) {
                System.out.print(point.getContent());
            }
            System.out.println();
        }
    }

    protected List<List<Point>> initUniverse(List<String> lines) {
        List<List<Point>> universe = new ArrayList<>();
        for (int yPos = 0; yPos < lines.get(0).length(); yPos++) {
            List<Point> row = new ArrayList<>();
            for (int xPos = 0; xPos < lines.size(); xPos++) {
                row.add(new Point(lines.get(yPos).charAt(xPos)));
            }
            universe.add(row);
        }
        return universe;
    }

    protected Set<Point> getGalaxies(List<List<Point>> universe) {
        Set<Point> points = new HashSet<>();
        for (List<Point> row : universe) {
            for (Point point : row) {
                if (point.getContent() == '#') {
                    points.add(point);
                }
            }
        }
        return points;
    }

    protected Set<Pair> getPairs(Set<Point> galaxies) {
        Set<Pair> pairs = new HashSet<>();
        for (Point p1 : galaxies) {
            for (Point p2 : galaxies) {
                if (!p1.equals(p2)) {
                    Pair pair = new Pair(p1, p2);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    protected List<Integer> computeDistances(Set<Pair> pairs) {
        List<Integer> distances = new ArrayList<>();
        for (Pair pair : pairs) {
            distances.add(pair.computeManhattanDistance());
        }
        return distances;
    }

    protected boolean isRowEmpty(List<Point> row) {
        for (Point point : row) {
            if (point.getContent() != '.') {
                return false;
            }
        }
        return true;
    }

    protected boolean isColumnEmpty(List<List<Point>> universe, int xPos) {
        for (List<Point> points : universe) {
            if (points.get(xPos).getContent() != '.') {
                return false;
            }
        }
        return true;
    }

}
