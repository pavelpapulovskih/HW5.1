package org.max.lesson1.game;

import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void game() {
        Game game = new Game();
        game.addCardToPlayer();
        game.checkHand(game.getGamer());
        game.addCardToCasino();
        game.checkHand(game.getCasino());
        System.out.println();
        System.out.println(game.checkWin().getName());
    }
}
