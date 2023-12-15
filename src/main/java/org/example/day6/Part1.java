package org.example.day6;

import java.util.List;

public class Part1 extends Day6 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<String> lines = part1.getLines();
        List<RaceInfo> raceInfos = part1.populateRaceInfos(lines);
        System.out.println(part1.getResult(raceInfos));
    }

}
