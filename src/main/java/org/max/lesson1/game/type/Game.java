package org.max.lesson1.game.type;

import org.max.lesson1.game.Deck;
import org.max.lesson1.game.DeckService;

public class Game {

    private Deck deck;

    public void newDeck() {
        DeckService deckService = new DeckService();
        deck = deckService.getNewDeck();
    }
}
