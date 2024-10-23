package org.citadel.models.pieces.movements;

import org.citadel.models.Coordinate;
import org.citadel.models.Player;
import org.citadel.models.pieces.Piece;

public class EventMoveKing extends EventMove {

    public EventMoveKing(Piece piece) {
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
