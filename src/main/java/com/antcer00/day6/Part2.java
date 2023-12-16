package com.antcer00.day6;

import java.util.List;

import static java.lang.Long.parseLong;

public class Part2 extends Day6 {

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        List<String> lines = part2.getLines();
        List<RaceInfo> raceInfos = part2.populateRaceInfos(lines);
        RaceInfo singleRace = part2.getSingleRace(raceInfos);
        System.out.println(part2.getResult(List.of(singleRace)));
    }

    private RaceInfo getSingleRace(List<RaceInfo> raceInfos) {
        StringBuilder time = new StringBuilder();
        StringBuilder distanceRecord = new StringBuilder();
        for (RaceInfo raceInfo : raceInfos) {
            time.append(raceInfo.getAvaiableTime());
            distanceRecord.append(raceInfo.getDistanceRecord());
        }
        return new RaceInfo(parseLong(time.toString()), parseLong(distanceRecord.toString()));
    }
}
