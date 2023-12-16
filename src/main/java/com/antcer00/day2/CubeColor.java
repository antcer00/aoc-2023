package com.antcer00.day2;

public enum CubeColor {
    RED("red"), BLUE("blue"), GREEN("green");

    public final String value;

    CubeColor(String value) {
        this.value = value;
    }

    public static CubeColor getCubeColorFromValue(String value) {
        if (RED.value.equals(value)) {
            return RED;
        } else if (BLUE.value.equals(value)) {
            return BLUE;
        } else if (GREEN.value.equals(value)) {
            return GREEN;
        }
        return null;
    }
}
