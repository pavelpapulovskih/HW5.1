package org.max.lesson1.game;

import org.max.lesson1.game.type.Ranks;
import org.max.lesson1.game.type.Suits;

public class Card {

    private Ranks rank;
    private Suits suit;
    private Player player;
    private Casino casino;

    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
