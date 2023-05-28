package org.max.home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс для реализации игры
 */
public class Game {

    private Player player;
    private List<Door> doors = new ArrayList<>();

    public Game(Player player) {
        this.player = player;
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        Collections.shuffle(doors);
    }

    public Door round (int door) {
        if (player.getRisk()) return doors.get(0);
        else {
            return doors.get(1).isPrize() ? doors.get(1) : doors.get(2);
        }
    }


}
