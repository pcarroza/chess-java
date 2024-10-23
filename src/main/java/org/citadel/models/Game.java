package org.citadel.models;

public class Game {

    private final Board board;

    public Game(Observer observer) {
        board = new Board();
        board.setObserver(observer);
    }

    public void put(Coordinate coordinate) {
        board.put(coordinate);
    }

    public void remove(Coordinate coordinate) {
        board.remove(coordinate);
    }

    public void select(Coordinate coordinate) {
        board.select(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return board.isEmpty(coordinate);
    }

    public void initialize() {
        board.initialize();
    }

    public void begin() {
        board.begin();
    }

    public void end() {
        board.end();
    }

    public void exit() {
        board.exit();
    }
}
