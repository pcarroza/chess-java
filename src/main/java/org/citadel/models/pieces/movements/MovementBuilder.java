package org.citadel.models.pieces.movements;

import org.citadel.models.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovementBuilder {

    private final int SINGLE_STEP = 1;

    private List<Coordinate> movements;

    public List<Coordinate> createMovesWhitePieces(Piece piece) {
        var movements = createBaseMovements(piece, SINGLE_STEP);
        deletedCoordinate(piece);
        return movements;
    }

    public List<Coordinate> createMovesBlackPieces(Piece piece) {
        var movements = createBaseMovements(piece, -SINGLE_STEP);
        deletedCoordinate(piece);
        return movements;
    }

    private void deletedCoordinate(Piece piece) {
        Iterator<Coordinate> iterator = movements.iterator();
        while (iterator.hasNext()) {
            var coordinate = iterator.next();
            boolean exists;
            exists = piece.inDirection(coordinate);
            if (exists) {
                iterator.next();
            }
        }
    }

    private List<Coordinate> createBaseMovements(Piece piece, int direction) {
        movements = new ArrayList<>();

        int DOUBLE_STEP = 2;
        int LEFT_STEP = -1;
        int RIGHT_STEP = 1;

        movements.add(piece.getDisplacedCoordinate(DOUBLE_STEP * direction));
        movements.add(piece.getDisplacedCoordinate(SINGLE_STEP * direction));
        movements.add(piece.getDisplacedCoordinate(SINGLE_STEP * direction, LEFT_STEP));
        movements.add(piece.getDisplacedCoordinate(SINGLE_STEP * direction, RIGHT_STEP));

        return movements;
    }
}
