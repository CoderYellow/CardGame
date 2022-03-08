package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class GameRule {

    private final Strategy strategy;

    public int compare(Card card1, Card card2) {
        switch (strategy) {
            case NORMAL:
                return card1.compareTo(card2);
            default:
                throw new RuntimeException("strategy not specified!");
        }
    }

    @Getter
    @AllArgsConstructor
    public enum Strategy {
        NORMAL
    }
}
