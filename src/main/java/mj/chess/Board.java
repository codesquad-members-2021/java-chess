package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Piece;
import mj.chess.pieces.RepresentationMap;
import mj.chess.pieces.Type;
import mj.chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static mj.chess.utils.StringUtils.appendNewLine;

public class Board {
    private static final int FIRST_ROW = 0;
    private static final int SECOND_ROW = 1;
    private static final int THIRD_ROW = 2;
    private static final int FORTH_ROW = 3;
    private static final int FIFTH_ROW = 4;
    private static final int SIXTH_ROW = 5;
    private static final int SEVENTH_ROW = 6;
    private static final int EIGHTH_ROW = 7;
    private static final int SIZE_OF_ROW = 8;
    private final List<Piece> pieces = new ArrayList<>();
    private final StringBuilder[] cellsOfBoard = new StringBuilder[SIZE_OF_ROW];

    public Board() {
    }

    //TODO: 메소드의 역할을 잘 드러나도록 이름 더 직관적으로 바꿔보자
    private void add(Piece piece) {
        pieces.add(piece);
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
    }

     void initialize() {
        for (Type type : Type.values()) {
            for (Color color : Color.values()) {
                initPieces(color, type);
            }
        }
        initCellsOfBoard();
    }

    private void initPawns(Color color) {
        for (int i = 0; i < SIZE_OF_ROW; i++) {
            Piece pawn = (color == Color.WHITE) ? Piece.createWhitePawn() : Piece.createBlackPawn();
            this.add(pawn);
        }
    }

    private void initPieces(Color color, Type type) {
        Piece piece;

        switch (type) {
            case PAWN:
                piece = (color == Color.WHITE) ? Piece.createWhitePawn() : Piece.createBlackPawn();
                for (int i = 0; i < 8; i++) this.add(piece);
                break;
            case ROOK:
                piece = (color == Color.WHITE) ? Piece.createWhiteRook() : Piece.createBlackRook();
                for (int i = 0; i < 2; i++) this.add(piece);
                break;
            case KNIGHT:
                piece = (color == Color.WHITE) ? Piece.createWhiteKnight() : Piece.createBlackKnight();
                for (int i = 0; i < 2; i++) this.add(piece);
                break;
            case BISHOP:
                piece = (color == Color.WHITE) ? Piece.createWhiteBishop() : Piece.createBlackBishop();
                for (int i = 0; i < 2; i++) this.add(piece);
                break;
            case QUEEN:
                piece = (color == Color.WHITE) ? Piece.createWhiteQueen() : Piece.createBlackQueen();
                for (int i = 0; i < 1; i++) this.add(piece);
                break;
            case KING:
                piece = (color == Color.WHITE) ? Piece.createWhiteKing() : Piece.createBlackKing();
                for (int i = 0; i < 1; i++) this.add(piece);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    // TODO: 스트림으로 바꿔보자
    private void initCellsOfBoard() {
        StringBuilder blankRank = appendNewLine("........");

        for (int nthRow = 0; nthRow < SIZE_OF_ROW; nthRow++) {
            if (nthRow < SEVENTH_ROW && nthRow > SECOND_ROW)
                cellsOfBoard[nthRow] = blankRank;
        }

        cellsOfBoard[FIRST_ROW] = StringUtils.appendNewLine(getRowOfPieces(Color.BLACK));
        cellsOfBoard[SECOND_ROW] = StringUtils.appendNewLine(getRowOfPawns(Color.BLACK));
        cellsOfBoard[SEVENTH_ROW] = StringUtils.appendNewLine(getRowOfPawns(Color.WHITE));
        cellsOfBoard[EIGHTH_ROW] = StringUtils.appendNewLine(getRowOfPieces(Color.WHITE));
    }

    int countPieces() {
        return pieces.size();
    }

    int countPawns() {
        return (int) pieces.stream()
                .filter(pawn -> pawn.getType() == Type.PAWN)
                .count();
    }

    //TODO: 스트림으로 바꿔보자
    public String getLocationOfPieces() {
        StringBuilder result = new StringBuilder();
        for (StringBuilder rowOfBoard : cellsOfBoard) result.append(rowOfBoard);

        return result.toString();
    }

    private String getRowOfPawns(Color color) {
        return pieces.stream()
                .filter(piece -> piece.getType() == Type.PAWN && piece.getColor() == color)
                .map(Piece::getRepresentation)
                .collect(joining());
    }

    private String getRowOfPieces(Color color) {
        RepresentationMap representationMap = new RepresentationMap();
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(representationMap.getRepresentation(color, Type.ROOK))
                .append(representationMap.getRepresentation(color, Type.KNIGHT))
                .append(representationMap.getRepresentation(color, Type.BISHOP))
                .append(representationMap.getRepresentation(color, Type.QUEEN))
                .append(representationMap.getRepresentation(color, Type.KING))
                .append(representationMap.getRepresentation(color, Type.BISHOP))
                .append(representationMap.getRepresentation(color, Type.KNIGHT))
                .append(representationMap.getRepresentation(color, Type.ROOK))
                .toString();
    }
}
