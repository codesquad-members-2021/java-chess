package mj.chess;

import mj.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static mj.chess.utils.StringUtil.appendNewLine;

public class Board {
    private final List<Piece> firstRow = new ArrayList<>();
    private final List<Piece> secondRow = new ArrayList<>();
    private final List<Piece> thirdRow = new ArrayList<>();
    private final List<Piece> forthRow = new ArrayList<>();
    private final List<Piece> fifthRow = new ArrayList<>();
    private final List<Piece> sixthRow = new ArrayList<>();
    private final List<Piece> seventhRow = new ArrayList<>();
    private final List<Piece> eighthRow = new ArrayList<>();

    private int numOfPieces = 0;

    public Board() {
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
        return new StringBuilder()
                .append(appendNewLine(getStringFromRow(firstRow)))
                .append(appendNewLine(getStringFromRow(secondRow)))
                .append(appendNewLine(getStringFromRow(thirdRow)))
                .append(appendNewLine(getStringFromRow(forthRow)))
                .append(appendNewLine(getStringFromRow(fifthRow)))
                .append(appendNewLine(getStringFromRow(sixthRow)))
                .append(appendNewLine(getStringFromRow(seventhRow)))
                .append(appendNewLine(getStringFromRow(eighthRow)))
                .toString();
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
        for (int i = 0; i < 8; i++) {
            secondRow.add(pawn);
            numOfPieces++;
        }
    }

    private void initWhitePawns() {
        Piece pawn = Piece.PieceMaker.createWhitePawn();
        for (int i = 0; i < 8; i++) {
            seventhRow.add(pawn);
            numOfPieces++;
        }
    }

    private void initRoyalPieces() {
        initBlackRoyalPieces();
        initWhiteRoyalPieces();
    }

    private void initBlackRoyalPieces() {
        firstRow.add(Piece.PieceMaker.createBlackRook());
        firstRow.add(Piece.PieceMaker.createBlackKnight());
        firstRow.add(Piece.PieceMaker.createBlackBishop());
        firstRow.add(Piece.PieceMaker.createBlackQueen());
        firstRow.add(Piece.PieceMaker.createBlackKing());
        firstRow.add(Piece.PieceMaker.createBlackBishop());
        firstRow.add(Piece.PieceMaker.createBlackKnight());
        firstRow.add(Piece.PieceMaker.createBlackRook());
        numOfPieces += 8;
    }

    private void initWhiteRoyalPieces() {
        eighthRow.add(Piece.PieceMaker.createWhiteRook());
        eighthRow.add(Piece.PieceMaker.createWhiteKnight());
        eighthRow.add(Piece.PieceMaker.createWhiteBishop());
        eighthRow.add(Piece.PieceMaker.createWhiteQueen());
        eighthRow.add(Piece.PieceMaker.createWhiteKing());
        eighthRow.add(Piece.PieceMaker.createWhiteBishop());
        eighthRow.add(Piece.PieceMaker.createWhiteKnight());
        eighthRow.add(Piece.PieceMaker.createWhiteRook());
        numOfPieces += 8;
    }

    private void initBlank() {
        for (int i = 0; i < 8; i++) {
            thirdRow.add(Piece.PieceMaker.createBlack());
            forthRow.add(Piece.PieceMaker.createBlack());
            fifthRow.add(Piece.PieceMaker.createBlack());
            sixthRow.add(Piece.PieceMaker.createBlack());
        }
    }
}
