package org.max.seminar;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Main класс для запуска BlackJack в цикле
 */
public class PlayGame {

    public static void main(String[] args) {

        Gamer gamer = new Gamer(7);
        Casino casino = new Casino(0);
        HashMap<String, String> statistic = new LinkedHashMap<>();

        for (int i = 0; i<100; i++) {
            Game game = new Game(gamer, casino);

            statistic.put("Game № " + i, game.round(game));
        }

        statistic.entrySet().forEach(System.out::println);

    }


}
