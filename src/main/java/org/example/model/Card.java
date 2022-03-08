package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Card {
    private CardNumber cardNumber;

    private Suit suit;

    public int compareTo(Card card) {
        return getCardNumber().code * 13 + getSuit().code * 4;
    }




    @Getter
    @AllArgsConstructor
    public enum CardNumber {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private final Integer code;

    }

    @Getter
    @AllArgsConstructor
    public enum Suit {
        DIAMOND(1),
        SPADE(2),
        HEART(3),
        CLUB(4);

        private final Integer code;
    }


}
