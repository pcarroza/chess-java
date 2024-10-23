package org.citadel.models.pieces;

import org.citadel.models.Board;
import org.citadel.models.Coordinate;
import org.citadel.models.pieces.movements.EventMove;

public abstract class Piece implements Cloneable {

    protected EventMove eventMove;

    private Coordinate position;

    protected Board board;

    public Piece(Coordinate coordinate) {
        position = coordinate;
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
        return board.isWhite();
    }

    public boolean isBlack() {
        return board.isBlack();
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
