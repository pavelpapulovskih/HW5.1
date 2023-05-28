package org.max.seminar;

import org.max.seminar.exception.DeckEmptyException;

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
