package org.citadel.models.pieces;

import org.citadel.common.tools.BoardConstants;
import org.citadel.models.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class FlatBuilder {

    public static List<Piece> getPiecesWhite() {
        final int rowForPawns = 2;
        final int rowOfWhitePieces = 1;
        return createPieces(rowForPawns, rowOfWhitePieces);
    }

    public static List<Piece> getPiecesBlack() {
        final int rowForPawns = 7;
        final int rowOfBlackPieces = 8;
        return createPieces(rowForPawns, rowOfBlackPieces);
    }

    private static List<Piece> createPieces(int rowForPawns, int rowOfPieces) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 1; i <= BoardConstants.NUMBER_OF_PAWN; i++) {
            pieces.add(new Pawn(new Coordinate(rowForPawns, i)));
        }
        pieces.add(new Rook(new Coordinate(rowOfPieces, 1)));
        pieces.add(new Knight(new Coordinate(rowOfPieces, 2)));
        pieces.add(new Bishop(new Coordinate(rowOfPieces, 3)));
        pieces.add(new Queen(new Coordinate(rowOfPieces, 4)));
        pieces.add(new King(new Coordinate(rowOfPieces, 5)));
        pieces.add(new Bishop(new Coordinate(rowOfPieces, 6)));
        pieces.add(new Knight(new Coordinate(rowOfPieces, 7)));
        pieces.add(new Rook(new Coordinate(rowOfPieces, 8)));
        return pieces;
    }
}
