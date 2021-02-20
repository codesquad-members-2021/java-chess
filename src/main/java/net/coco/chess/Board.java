package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.pieces.PieceType;
import net.coco.valid.PieceValid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Piece> whiteOtherPieces = new ArrayList<>();
    private List<Piece> blackOtherPieces = new ArrayList<>();
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private static final int BOARD_CELLS = 8;


    public void addPawn(Piece piece) {
        if (!PieceValid.isPawn(piece))
            return;
        if (piece.getColor().equals(Piece.WHITE))
            whitePawns.add(piece);
        else
            blackPawns.add(piece);
    }

    public void addOtherPiece(Piece piece) {
        if (!PieceValid.isOtherPiece(piece))
            return;
        if (piece.getColor().equals(Piece.WHITE))
            whiteOtherPieces.add(piece);
        else
            blackOtherPieces.add(piece);
    }

    public int getPiecesSize() {
        return whitePawns.size() + blackPawns.size()
                + whiteOtherPieces.size() + blackOtherPieces.size();
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public void initialize() {
        clearPieces();
        for (int i = 0; i < BOARD_CELLS; i++) {
            addPawn(Piece.createWhitePawn());
            addPawn(Piece.createBlackPawn());
        }
        addWhiteOtherPieceToPieces();
        addBlackOtherPieceToPieces();
    }

    private void clearPieces() {
        whitePawns.clear();
        blackPawns.clear();
        whiteOtherPieces.clear();
        blackOtherPieces.clear();
    }


    public String getPawnsResult(String color) {
        PieceValid.checkColorType(color);
        if (color.equals(Piece.WHITE))
            return getPiecesToString(whitePawns);
        else
            return getPiecesToString(blackPawns);
    }

    public String getOtherPiecesResult(String color) {
        PieceValid.checkColorType(color);
        if (color.equals(Piece.WHITE))
            return getPiecesToString(whiteOtherPieces);
        else
            return getPiecesToString(blackOtherPieces);
    }

    private String getPiecesToString(List<Piece> pieces) {
        return pieces.stream()
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

    private void addBlackOtherPieceToPieces() {
        addOtherPiece(Piece.createBlackRook());
        addOtherPiece(Piece.createBlackKnight());
        addOtherPiece(Piece.createBlackBishop());
        addOtherPiece(Piece.createBlackQueen());
        addOtherPiece(Piece.createBlackKing());
        addOtherPiece(Piece.createBlackBishop());
        addOtherPiece(Piece.createBlackKnight());
        addOtherPiece(Piece.createBlackRook());
    }

    private void addWhiteOtherPieceToPieces() {
        addOtherPiece(Piece.createWhiteRook());
        addOtherPiece(Piece.createWhiteKnight());
        addOtherPiece(Piece.createWhiteBishop());
        addOtherPiece(Piece.createWhiteQueen());
        addOtherPiece(Piece.createWhiteKing());
        addOtherPiece(Piece.createWhiteBishop());
        addOtherPiece(Piece.createWhiteKnight());
        addOtherPiece(Piece.createWhiteRook());
    }
}
