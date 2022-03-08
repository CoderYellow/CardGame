package org.example.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data

public class Player {
    private List<Card> cards = new ArrayList<>();

    public Player(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    private GameRule gameRule;

    public void deal(Card card) {
        cards.add(card);
    }

    public void onDealFinished() {
        cards.sort(gameRule::compare);
    }
}
