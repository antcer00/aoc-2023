package com.antcer00.day15;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Box {
    private List<Lens> lenses = new ArrayList<>();
}
