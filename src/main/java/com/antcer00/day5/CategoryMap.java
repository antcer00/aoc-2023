package com.antcer00.day5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryMap<SOURCE extends Category, DESTINATION extends Category> {
    private SOURCE source;
    private DESTINATION destination;

    private List<Interval> intervals = new ArrayList<>();

    public void clear() {
        this.source = null;
        this.destination = null;
        this.intervals.clear();
    }

    public boolean isEmpty() {
        return this.source == null && this.destination == null && this.intervals.isEmpty();
    }

    public CategoryMap<SOURCE, DESTINATION> copyOf() {
        return new CategoryMap<>(getSource(), getDestination(), List.copyOf(getIntervals()));
    }
}
