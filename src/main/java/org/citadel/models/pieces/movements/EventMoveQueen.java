package org.citadel.models.pieces.movements;

import org.citadel.models.Coordinate;
import org.citadel.models.pieces.Piece;

public class EventMoveQueen extends EventMove {

    public EventMoveQueen(Piece piece) {
        super(piece);
    }

    @Override
    public boolean isMovementValid(Coordinate coordinate) {
        return false;
    }

    @Override
    public void loadPieceMoves() {

    }

    @Override
    public void accept(VisitorEventMove visitorEventMove) {
    }
}