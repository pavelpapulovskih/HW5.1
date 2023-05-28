package org.max.home;


/**
 * Main класс для запуска Монти Холла в цикле
 */
public class PlayGame {

    public static void main(String[] args) {

        Player gamer = new Player("Игрок", true);
        int statisticWin = 0;
        int step;

        for (step = 0; step<1000; step++) {
            Game game = new Game(gamer);

            if (game.round(0).isPrize()) statisticWin++;
        }

        System.out.println("Из " + step + " игр игрок выиграл " + statisticWin);

    }
}
