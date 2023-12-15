package org.example.day15;

import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Lens {

    private String label = "";

    private int focalLength = -1;

    public Lens(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Lens)) {
            return false;
        }
        if (this.label.equals(((Lens) obj).getLabel())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
