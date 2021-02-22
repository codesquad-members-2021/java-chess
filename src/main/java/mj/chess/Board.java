package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Piece;
import mj.chess.pieces.Type;
import mj.chess.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static mj.chess.utils.StringUtil.appendNewLine;

public class Board {
    private static final int FIRST_ROW = 0;
    private static final int SECOND_ROW = 1;
    private static final int SEVENTH_ROW = 6;
    private static final int EIGHTH_ROW = 7;
    private static final int SIZE_OF_ROW = 8;
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final String[] cellsOfBoard = new String[SIZE_OF_ROW];

    public Board() {
    }

    public void addPiece(Piece piece) {
        if (piece.isWhite()) {
            whitePieces.add(piece);
        }
        if (piece.isBlack()) {
            blackPieces.add(piece);
        }
    }

    void initialize() {
        for (Type type : Type.values()) {
            for (Color color : Color.values()) {
                type.initPiece(this, color);
            }
        }
        initCellsOfBoard();
    }

    private void initCellsOfBoard() {
        String blankRank = appendNewLine("........");

        for (int nthRow = 0; nthRow < SIZE_OF_ROW; nthRow++) {
            if (nthRow < SEVENTH_ROW && nthRow > SECOND_ROW)
                cellsOfBoard[nthRow] = blankRank;
        }

        cellsOfBoard[FIRST_ROW] = StringUtil.appendNewLine(getRowOfPieces(Color.BLACK));
        cellsOfBoard[SECOND_ROW] = StringUtil.appendNewLine(getRowOfPawns(Color.BLACK));
        cellsOfBoard[SEVENTH_ROW] = StringUtil.appendNewLine(getRowOfPawns(Color.WHITE));
        cellsOfBoard[EIGHTH_ROW] = StringUtil.appendNewLine(getRowOfPieces(Color.WHITE));
    }

    int countPieces() {
        return whitePieces.size() + blackPieces.size();
    }

    public String getLocationOfPieces() {
        return String.join("", cellsOfBoard);
    }

    private String getRowOfPawns(Color color) {

        List<Piece> pieces;

        if (color == Color.BLACK) {
            pieces = blackPieces;
        } else if (color == Color.WHITE) {
            pieces = whitePieces;
        } else {
            throw new IllegalArgumentException("color is White/Black else");
        }

        return pieces.stream()
                .filter(piece -> piece.getType() == Type.PAWN && piece.getColor() == color)
                .map(Piece::getRepresentation)
                .collect(joining());
    }

    private String getRowOfPieces(Color color) {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(Type.ROOK.getRepresentation(color))
                .append(Type.KNIGHT.getRepresentation(color))
                .append(Type.BISHOP.getRepresentation(color))
                .append(Type.QUEEN.getRepresentation(color))
                .append(Type.KING.getRepresentation(color))
                .append(Type.BISHOP.getRepresentation(color))
                .append(Type.KNIGHT.getRepresentation(color))
                .append(Type.ROOK.getRepresentation(color))
                .toString();
    }
}
