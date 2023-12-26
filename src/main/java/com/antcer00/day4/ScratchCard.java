package com.antcer00.day4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    private int cardId;
    private Set<Integer> winningNumbers;
    private Set<Integer> numbersYouHave;
}
