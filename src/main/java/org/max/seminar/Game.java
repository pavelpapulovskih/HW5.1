package org.max.seminar;

import org.max.seminar.exception.DeckEmptyException;

public class Game {

    private Deck deck;

    public Game(Gamer gamer, Casino casino) {
        this.gamer = gamer;
        this.casino = casino;
        newDeck();
    }

    private Gamer gamer;
    private Casino casino;
    private final int max = 21;

    //Новая колода
    public void newDeck() {
        DeckService deckService = new DeckService();
        deck = deckService.getNewDeck();
    }

    public Game() {
        this.gamer = new Gamer(0);
        this.casino = new Casino(0);
        newDeck();
    }


    //Добавление карты в руку игрока
    public void addCardToPlayer() {
        try {
            gamer.addCard(deck.getCard());
        } catch (DeckEmptyException e) {
            e.printStackTrace();
        }
    }

    //Добавление карты в руку казино
    public void addCardToCasino() {
        try {
            casino.addCard(deck.getCard());
        } catch (DeckEmptyException e) {
            e.printStackTrace();
        }
    }

    //Проверка что сумма на руке не выше лимита
    private boolean checkHand(Player player) {
        return player.getHandSumm() <= max ;
    }

    //Проверка что сумма на руке не риска и можно взять еще карту
    private boolean checkRisk(Player player) {
        return player.getHandSumm() > max - player.getRisk() ;
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

    /**
     * Этап в рамках одной игры
     * Игроку и казино раздаются карты, проверяется, что не привычили лимит
     * Если лимит не превышен проверяются риски
     * Иначе рекурсивно функция вызывает саму себя
     * @param game
     * @return
     */
    public String round (Game game) {

        game.addCardToPlayer();
        if (game.checkHand(game.getGamer())) {
            return game.getCasino().getName();
        }
        game.addCardToCasino();
        if (game.checkHand(game.getCasino())) {
            return game.getGamer().getName();
        }

        if (checkRisk(game.getGamer())) {
            if(gamer.getHandSumm() > casino.getHandSumm() && !checkRisk(game.getCasino())) {
                game.addCardToCasino();
            }
            return gamer.getHandSumm() > casino.getHandSumm()? gamer.getName() : casino.getName();
        }

        return round(game);
    }

}
