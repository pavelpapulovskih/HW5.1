package org.max.lesson1.game;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private List<Card> hand = new ArrayList<>();
    private int handSumm = 0;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void newGame (){
        hand.clear();
        handSumm = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
        handSumm = handSumm + card.getRanksValue();
    }

    public int getHandSumm() {
        return handSumm;
    }

    public String printHand() {
        String result = "Имя игрока: " + " name;\n" +
                "Рука игрока: ";

        for(Card card: hand) {
            result = result + card.getCardValue() + "\n";
        }

        return result;
    }

    public String getName() {
        return name;
    }
}
