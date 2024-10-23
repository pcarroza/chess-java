package org.citadel.models.pieces;

import org.citadel.models.Coordinate;

public class King extends Piece {

    public King(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public boolean isMovementValid(Coordinate coordinate) {
        return false;
    }

    @Override
    public void put(Coordinate coordinate) {

    }
}
