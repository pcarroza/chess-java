package org.citadel.controllers.local;

import org.citadel.models.Coordinate;
import org.citadel.models.Game;

public class LocalController {

    private final Game game;

    public LocalController(Game game) {
        this.game = game;
    }

    public void put(Coordinate coordinate) {
        game.put(coordinate);
    }

    public void select(Coordinate coordinate) {
        game.select(coordinate);
    }

    public void remove(Coordinate coordinate) {
        game.remove(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return game.isEmpty(coordinate);
    }

    public void initialize() {
        game.initialize();
    }

    public void begin() {
        game.begin();
    }

    public void end() {
        game.end();
    }

    public void exit() {
        game.exit();
    }
}
