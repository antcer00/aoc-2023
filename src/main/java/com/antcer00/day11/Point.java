package com.antcer00.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import static java.lang.Math.abs;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Point {
    private char content;
    private int xPos;
    private int yPos;

    public Point(char content) {
        this.content = content;
    }

    public int manhattanDistanceTo(Point point) {
        return abs(point.getXPos() - xPos) + abs(point.getYPos() - yPos);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        return ((Point) obj).getXPos() == xPos
                && ((Point) obj).getYPos() == yPos
                && ((Point) obj).getContent() == content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, xPos, yPos);
    }

    public void setPositions(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}