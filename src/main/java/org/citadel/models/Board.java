package org.citadel.models;

import org.citadel.common.tools.ClosedInterval;
import org.citadel.models.pieces.Piece;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import static org.citadel.common.tools.BoardConstants.HEIGHT;
import static org.citadel.common.tools.BoardConstants.WIDTH;
import static org.citadel.common.tools.Terminal.input;
import static org.citadel.common.tools.Terminal.writeln;
import static org.citadel.models.Player.BLACK;
import static org.citadel.models.Player.WHITE;
import static org.citadel.models.pieces.FlatBuilder.getPiecesBlack;
import static org.citadel.models.pieces.FlatBuilder.getPiecesWhite;

public class Board extends Subject {

    private final Map<Player, List<Piece>> flatMap;

    private final Map<Player, List<Piece>> deletedPiecesMap;

    private Piece selectedPiece;

    private final Turn turn;

    private final ClosedInterval<Integer> LIMITS = new ClosedInterval<>(HEIGHT, WIDTH);

    public Board() {
        flatMap = Map.of(BLACK, getPiecesBlack(), WHITE, getPiecesWhite());
        flatMap.values().forEach(pieces -> pieces.forEach(piece -> piece.setBoard(this)));
        turn = new Turn();
        deletedPiecesMap = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
    }

    public void put(Coordinate coordinate) {
        assert coordinate != null;
        assert !assertLimitsBoard(coordinate);
        selectedPiece.put(coordinate);
    }

    public void select(Coordinate coordinate) {
        assert coordinate != null;
        assert !assertLimitsBoard(coordinate);
        selectedPiece = flatMap.get(getCurrentPlayer())
                .stream()
                .filter(piece -> piece.isPresent(coordinate))
                .findFirst()
                .orElse(null);
    }

    public void remove(Coordinate coordinate) {
        assert coordinate != null;
        assert !assertLimitsBoard(coordinate);
        flatMap.get(getCurrentPlayer()).removeIf(piece -> {
            if (piece.isPresent(coordinate)) {
                deletedPiecesMap.get(getCurrentPlayer()).add(piece);
                return true;
            }
            return false;
        });
    }

    private boolean assertLimitsBoard(Coordinate coordinate) {
        return LIMITS.isIncluded(coordinate.getRow()) && LIMITS.isIncluded(coordinate.getColumn());
    }

    public boolean isEmpty(Coordinate coordinate) {
        return flatMap.values().stream().noneMatch(pieces -> pieces.stream().anyMatch(piece -> piece.isPresent(coordinate)));
    }

    public Player getCurrentPlayer() {
        return turn.getPlayer();
    }

    public Player getRivalPlayer() {
        Turn otherTurn = this.turn.clone();
        otherTurn.change();
        return otherTurn.getPlayer();
    }

    public void change() {
        turn.change();
    }

    public boolean isTheWhitePieceSelected(Coordinate coordinate) {
        return !isEmpty(coordinate) && isWhite(coordinate);
    }

    public boolean isTheBlackPieceSelected(Coordinate coordinate) {
        return !isEmpty(coordinate) && isBlack(coordinate);
    }

    private boolean isWhite(Coordinate coordinate) {
        return flatMap.get(WHITE).stream().anyMatch(piece -> piece.isPresent(coordinate));
    }

    private boolean isBlack(Coordinate coordinate) {
        return flatMap.get(BLACK).stream().anyMatch(piece -> piece.isPresent(coordinate));
    }

    public boolean isWhite() {
        return getCurrentPlayer().equals(WHITE);
    }

    public boolean isBlack() {
        return getCurrentPlayer().equals(BLACK);
    }

    public boolean isMovementValid(Coordinate coordinate) {
        if (assertLimitsBoard(coordinate)) {
            return false;
        }
        return selectedPiece.isMovementValid(coordinate);
    }

    public boolean inDirection(Coordinate coordinate) {
        return flatMap
                .get(getCurrentPlayer())
                .stream()
                .anyMatch(piece -> piece.isDiagonal(coordinate) || piece.isInverse(coordinate));
    }

    public boolean finished() {
        return true;
    }

    public static void main(String[] args) {

        Board board = new Board();

        boolean ok = false;

        int row;

        int column;

        writeln("" + board.isEmpty(new Coordinate(3, 1)));

        do {

            boolean isSelected = false;
            do {
                writeln("SELECCIONAR PIEZA DEL JUGADO " + board.getCurrentPlayer());
                row = input("ROW", Integer.class);
                column = input("COLUMN", Integer.class);
                isSelected = board.isTheBlackPieceSelected(new Coordinate(row, column));
                writeln("" + isSelected);
                if (isSelected) {
                    board.select(new Coordinate(row, column));
                }
            } while (!isSelected);

            writeln("MOVER PIEZA " + board.getCurrentPlayer());

            row = input("ROW: ", Integer.class);
            column = input("COLUMN: ", Integer.class);

            boolean right = board.isMovementValid(new Coordinate(row, column));

            writeln("" + right);

            if (board.finished()) {
                ok = true;
            }

        } while (!ok);
    }

}
