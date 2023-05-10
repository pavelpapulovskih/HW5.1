package org.max.lesson1.game;

import org.max.lesson1.game.exception.DeckEmptyException;
import org.max.lesson1.game.type.Ranks;
import org.max.lesson1.game.type.Suits;

import java.util.HashMap;
import java.util.List;

/**
 * Колода
 */
public class Deck {

    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Card getCard() throws DeckEmptyException {
        if(cards.isEmpty()) {
            throw new DeckEmptyException("Колода пустая");
        }
        Card result = cards.get(0);
        cards.remove(result);
        return result;
    }

    public List<Card> getCards() {
        return cards;
    }


}
