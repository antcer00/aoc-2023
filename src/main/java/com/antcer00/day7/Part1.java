package com.antcer00.day7;

import com.antcer00.utils.Utils;

import java.util.List;

public class Part1 extends Day7 {

    public static void main(String[] args) {
        Day7 day7 = new Day7();
        List<String> lines = Utils.getLines(INPUT_PATH);
        List<Hand> hands = day7.getHands(lines);
        hands.sort(Hand::compareTo);
        System.out.println(computeTotalWinnings(hands));
    }
}
