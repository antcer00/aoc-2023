package com.antcer00.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pair {
    private Point p1;
    private Point p2;

    public int computeManhattanDistance() {
        return p1.manhattanDistanceTo(p2);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) return false;
        return (((Pair) obj).getP1().equals(p1) && ((Pair) obj).getP2().equals(p2))
                || (((Pair) obj).getP1().equals(p2) && ((Pair) obj).getP2().equals(p1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2) + Objects.hash(p2, p1);
    }
}