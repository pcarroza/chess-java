package org.citadel.models.pieces.movements;

import org.citadel.models.Coordinate;
import org.citadel.models.pieces.Pawn;


public class EventMovePawn extends EventMove {

    public EventMovePawn(Pawn pawn) {
        super(pawn);
    }

    public boolean isMovementValid(Coordinate coordinate) {
        loadPieceMoves();
        return movements.contains(coordinate);
    }

    @Override
    public void loadPieceMoves() {
        if (piece.isWhite()) {
            movements = new MovementBuilder().createMovesWhitePieces(piece);
        } else if (piece.isBlack()) {
            movements = new MovementBuilder().createMovesBlackPieces(piece);
        } else {
            assert false;
        }
    }

    @Override
    public void accept(VisitorEventMove visitorEventMove) {
        visitorEventMove.visit(this);
    }
}
