package mj.chess;

import mj.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static mj.chess.utils.StringUtil.appendNewLine;

public class Board {
    private int numOfPieces = 0;
    private final int ROWS = 8;

    private final int FIRST_ROW = 0;
    private final int SECOND_ROW = 1;
    private final int THIRD_ROW = 2;
    private final int FORTH_ROW = 3;
    private final int FIFTH_ROW = 4;
    private final int SIXTH_ROW = 5;
    private final int SEVENTH_ROW = 6;
    private final int EIGHTH_ROW = 7;

    private final List[] rows = new ArrayList[ROWS];

    public Board() {
        initRows();
    }

    public void initialize() {
        initPawns();
        initRoyalPieces();
        initBlank();
    }

    public int countPieces() {
        return numOfPieces;
    }

    public String getLocationOfPieces() {
        return IntStream.range(0, ROWS)
                .mapToObj(row -> appendNewLine(getStringFromRow(rows[row])))
                .collect(joining());
    }

    private void initRows() {
        for (int row = 0; row < ROWS; row++) {
            rows[row] = new ArrayList<Piece>();
        }
    }

    private String getStringFromRow(List<Piece> row) {
        return row.stream()
                .map(Piece::getRepresentation)
                .collect(joining());
    }

    private void initPawns() {
        initBlackPawns();
        initWhitePawns();
    }

    private void initBlackPawns() {
        Piece pawn = Piece.PieceMaker.createBlackPawn();

        for (int i = 0; i < ROWS; i++) {
            rows[SECOND_ROW].add(pawn);
            numOfPieces++;
        }
    }

    private void initWhitePawns() {
        Piece pawn = Piece.PieceMaker.createWhitePawn();
        for (int i = 0; i < ROWS; i++) {
            rows[SEVENTH_ROW].add(pawn);
            numOfPieces++;
        }
    }

    private void initRoyalPieces() {
        initBlackRoyalPieces();
        initWhiteRoyalPieces();
    }

    private void initBlackRoyalPieces() {
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackRook());
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackKnight());
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackBishop());
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackQueen());
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackKing());
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackBishop());
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackKnight());
        rows[FIRST_ROW].add(Piece.PieceMaker.createBlackRook());
        numOfPieces += ROWS;
    }

    private void initWhiteRoyalPieces() {
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteRook());
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteKnight());
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteBishop());
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteQueen());
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteKing());
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteBishop());
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteKnight());
        rows[EIGHTH_ROW].add(Piece.PieceMaker.createWhiteRook());
        numOfPieces += ROWS;
    }

    private void initBlank() {
        for (int i = 0; i < ROWS; i++) {
            for (int row = THIRD_ROW; row < SEVENTH_ROW; row++) {
                rows[row].add(Piece.PieceMaker.createBlack());
            }
        }
    }
}
