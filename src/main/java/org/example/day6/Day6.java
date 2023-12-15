package org.example.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

public class Day6 {

    private static final String INPUT_PATH = "src/main/resources/input/day6/input.txt";

    protected List<RaceInfo> populateRaceInfos(List<String> lines) {
        List<RaceInfo> raceInfos = new ArrayList<>();
        String[] timesArrayString = lines.get(0).split(":")[1].trim().split("\\s+");
        String[] distancesArrayString = lines.get(1).split(":")[1].trim().split("\\s+");
        if (timesArrayString.length != distancesArrayString.length) {
            throw new RuntimeException("The number of recorded distances and times is not equal.");
        }
        for (int i = 0; i < timesArrayString.length; i++) {
            raceInfos.add(new RaceInfo(parseLong(timesArrayString[i]), parseLong(distancesArrayString[i])));
        }
        return raceInfos;
    }

    protected long getResult(List<RaceInfo> raceInfos) {
        List<Long> numberOfWinningStrategies = new ArrayList<>();
        for (RaceInfo raceInfo : raceInfos) {
            numberOfWinningStrategies.add(countWinningStrategies(raceInfo));
        }
        return multiply(numberOfWinningStrategies);
    }

    private long countWinningStrategies(RaceInfo raceInfo) {
        List<Long> possibleStrategies = getPossibleStrategiesForRace(raceInfo);
        List<Long> winningStrategies = filterWinningStrategies(possibleStrategies, raceInfo);
        return winningStrategies.size();
    }

    private List<Long> getPossibleStrategiesForRace(RaceInfo raceInfo) {
        List<Long> possibleStrategies = new ArrayList<>();
        for (long holdButtonTime = 0; holdButtonTime < raceInfo.getAvaiableTime(); holdButtonTime++) {
            possibleStrategies.add(getDistanceTravelled(raceInfo.getAvaiableTime(), holdButtonTime));
        }
        return possibleStrategies;
    }

    private long getDistanceTravelled(long avaiableTime, long holdButtonTime) {
        long remainingTime = avaiableTime - holdButtonTime;
        return holdButtonTime * remainingTime;
    }

    private List<Long> filterWinningStrategies(List<Long> possibleStrategies, RaceInfo raceInfo) {
        return possibleStrategies.stream()
                .filter(s -> s > raceInfo.getDistanceRecord())
                .collect(Collectors.toList());
    }

    protected long multiply(List<Long> list) {
        return list.stream().reduce(1L, (a, b) -> a * b);
    }

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
}
