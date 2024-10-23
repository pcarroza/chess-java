package org.citadel.models.pieces.movements;

import org.citadel.models.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public abstract class EventMove {

    protected List<Coordinate> movements;

    protected Piece piece;

    public EventMove(Piece piece) {
        this.piece = piece;
    }

    public abstract boolean isMovementValid(Coordinate coordinate);

    public abstract void loadPieceMoves();

    public abstract void accept(VisitorEventMove visitorEventMove);
}
