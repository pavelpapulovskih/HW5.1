package org.max.lesson1.game;

import org.max.lesson1.game.exception.DeckEmptyException;

public class Game {

    private Deck deck;
    private Gamer gamer;
    private Casino casino;
    private final int max = 21;

    public void newDeck() {
        DeckService deckService = new DeckService();
        deck = deckService.getNewDeck();
    }

    public Game() {
        this.gamer = new Gamer();
        this.casino = new Casino();
        newDeck();
    }

    public void addCardToPlayer() {
        try {
            gamer.addCard(deck.getCard());
        } catch (DeckEmptyException e) {
            e.printStackTrace();
        }
    }

    public void addCardToCasino() {
        try {
            casino.addCard(deck.getCard());
        } catch (DeckEmptyException e) {
            e.printStackTrace();
        }
    }

    public boolean checkHand(Player player) {
        return player.getHandSumm() <= max ;
    }

    public void printHand(Player player) {
        System.out.println(player.printHand());
    }

    public Gamer getGamer() {
        return gamer;
    }

    public Casino getCasino() {
        return casino;
    }

    public Player checkWin() {
        if(!checkHand(gamer)) return casino;
        if(!checkHand(casino)) return gamer;
        return gamer.getHandSumm() >= casino.getHandSumm()? gamer : casino;
    }
}
