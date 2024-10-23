package org.citadel.models.pieces.movements;

import org.citadel.models.Coordinate;
import org.citadel.models.pieces.Piece;

public class EventMoveRook extends EventMove {

    public EventMoveRook(Piece piece) {
        super(piece);
    }

    @Override
    public boolean isMovementValid(Coordinate coordinate) {
        return false;
    }

    @Override
    public void loadPieceMoves() {

    }
}
