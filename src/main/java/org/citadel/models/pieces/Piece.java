package org.citadel.models.pieces;

import org.citadel.models.Board;
import org.citadel.models.Coordinate;
import org.citadel.models.Player;
import org.citadel.models.pieces.movements.EventMove;

public abstract class Piece implements Cloneable {

    protected EventMove eventMove;

    private Coordinate position;

    protected Board board;

    protected Player color;

    public Piece(Coordinate coordinate) {
        position = coordinate;
    }

    public void setColor(Player player) {
        color = player;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setCoordinate(Coordinate coordinate) {
        position = coordinate;
    }

    public Coordinate getCoordinate() {
        return position;
    }

    public Coordinate getDisplacedCoordinate(int row, int column) {
        return getCoordinate().displaced(row, column);
    }

    public Coordinate getDisplacedCoordinate(int row) {
        return getCoordinate().displaced(row);
    }

    public boolean isPresent(Coordinate coordinate) {
        return position.equals(coordinate);
    }

    public boolean isMovementValid(Coordinate coordinate) {
        assert false;
        return false;
    }

    public void put(Coordinate coordinate) {
        assert false;
    }

    public boolean isWhite() {
        return color == Player.WHITE;
    }

    public boolean isBlack() {
        return color == Player.BLACK;
    }

    public boolean isDiagonal(Coordinate coordinate) {
        return getCoordinate().diagonal(coordinate);
    }

    public boolean isInverse(Coordinate coordinate) {
        return getCoordinate().inverse(coordinate);
    }

    public boolean inDirection(Coordinate coordinate) {
        return board.inDirection(coordinate);
    }

    @Override
    public Piece clone() {
        try {
            Piece clone = (Piece) super.clone();
            if (position != null) {
                clone.position = position.clone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
