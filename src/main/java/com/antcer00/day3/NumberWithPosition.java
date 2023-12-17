package com.antcer00.day3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NumberWithPosition {
    private int number;
    private Coordinate startPos;
    private Coordinate endPos;
}
