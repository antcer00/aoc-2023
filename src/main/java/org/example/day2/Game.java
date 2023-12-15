package org.example.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

    private int gameNumber;

    private List<Set<CubeExtraction>> extractionsList = new ArrayList<>();

}
