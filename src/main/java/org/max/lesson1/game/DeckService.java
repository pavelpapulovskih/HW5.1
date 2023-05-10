package org.max.lesson1.game;

import org.max.lesson1.game.type.Ranks;
import org.max.lesson1.game.type.Suits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckService {

    public Deck getNewDeck() {

        List<Card> cardList = new ArrayList<>();
        for(Ranks rank: Ranks.values()) {
            for (Suits suit: Suits.values()) {
                cardList.add(new Card(rank, suit));
            }
        }

        Deck result = new Deck(cardList);
        shuffle(result);
        return result;
    }

    private void shuffle(Deck deck) {
        Collections.shuffle(deck.getCards());
    }
}
