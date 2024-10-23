package org.citadel.models.pieces;

import org.citadel.models.Coordinate;
import org.citadel.models.pieces.movements.EventMovePawn;

public class Pawn extends Piece {

    private boolean initialState = true;

    public Pawn(Coordinate coordinate) {
        super(coordinate);
        eventMove = new EventMovePawn(this);
    }

    public void closed() {
        initialState = false;
    }

    public boolean isInitialState() {
        return initialState;
    }

    @Override
    public void put(Coordinate target) {
        setCoordinate(target.clone());
    }

    @Override
    public boolean isMovementValid(Coordinate coordinate) {
        if (isInitialState()) {
            closed();
            return eventMove.isMovementValid(coordinate);
        }
        return eventMove.isMovementValid(coordinate);
    }
}
