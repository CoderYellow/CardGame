package org.example.model;


import com.google.common.collect.Streams;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Dealer {
    private static final List<Card> cards;

    private List<Player> players = new ArrayList<>();

    static {
        cards = new ArrayList<>();
        Seq.of(Card.CardNumber.values())
                .crossJoin(Seq.of(Card.Suit.values()))
                .map(Dealer::convert)
                .collect(Collectors.toList());
    }

    private static Card convert(Tuple2<Card.CardNumber, Card.Suit> cardTuple) {
        return new Card(cardTuple.v1, cardTuple.v2);
    }

    public void join(Player player) {
        players.add(player);
    }

    public void deal() {
        Collections.shuffle(cards);

        int i, j;
        for (i = 0, j = 0; i < cards.size(); i++, j = i % players.size()) {
            players.get(j).deal(cards.get(i));
        }

        Streams.mapWithIndex(cards.stream(), Tuple2::new)
                .forEach(cardIndex -> players.get((int) (cardIndex.v2 % players.size())).deal(cardIndex.v1));

        players.forEach(Player::onDealFinished);

    }
}
