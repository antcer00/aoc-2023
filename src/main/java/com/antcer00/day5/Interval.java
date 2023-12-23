package com.antcer00.day5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Interval {
    private long sourceValue;
    private long destinationValue;
    private long range;

    public long getDestination(long value) {
        if (!isValueInSource(value)) {
            return value;
        }
        return (value - sourceValue) + destinationValue;
    }

    public boolean isValueInSource(long value) {
        if (value >= sourceValue && value < sourceValue + range) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return sourceValue == 0 && destinationValue == 0 && range == 0;
    }

}
