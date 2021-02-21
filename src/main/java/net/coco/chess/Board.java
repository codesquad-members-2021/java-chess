package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.valid.PieceValid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Piece> otherWhitePieces = new ArrayList<>();
    private List<Piece> otherBlackPieces = new ArrayList<>();
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private static final int BOARD_CELLS = 8;


    public void addWhitePawn(Piece piece) {
        if (!PieceValid.isPawn(piece) || !piece.isWhite()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }

        whitePawns.add(piece);
    }

    public void addBlackPawn(Piece piece) {
        if (!PieceValid.isPawn(piece) || !piece.isBlack()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }
        blackPawns.add(piece);
    }

    public void addOtherWhitePiece(Piece piece) {
        if (!PieceValid.isOtherPiece(piece) || !piece.isWhite()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }

        otherWhitePieces.add(piece);
    }

    public void addOtherBlackPiece(Piece piece) {
        if (!PieceValid.isOtherPiece(piece) || !piece.isBlack()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }
        otherBlackPieces.add(piece);
    }

    public int getPiecesSize() {
        return whitePawns.size() + blackPawns.size()
                + otherWhitePieces.size() + otherBlackPieces.size();
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
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        addWhiteOtherPieceToPieces();
        addBlackOtherPieceToPieces();
    }

    private void clearPieces() {
        whitePawns.clear();
        blackPawns.clear();
        otherWhitePieces.clear();
        otherBlackPieces.clear();
    }

    private void addBlackOtherPieceToPieces() {
        addOtherBlackPiece(Piece.createBlackRook());
        addOtherBlackPiece(Piece.createBlackKnight());
        addOtherBlackPiece(Piece.createBlackBishop());
        addOtherBlackPiece(Piece.createBlackQueen());
        addOtherBlackPiece(Piece.createBlackKing());
        addOtherBlackPiece(Piece.createBlackBishop());
        addOtherBlackPiece(Piece.createBlackKnight());
        addOtherBlackPiece(Piece.createBlackRook());
    }

    private void addWhiteOtherPieceToPieces() {
        addOtherWhitePiece(Piece.createWhiteRook());
        addOtherWhitePiece(Piece.createWhiteKnight());
        addOtherWhitePiece(Piece.createWhiteBishop());
        addOtherWhitePiece(Piece.createWhiteQueen());
        addOtherWhitePiece(Piece.createWhiteKing());
        addOtherWhitePiece(Piece.createWhiteBishop());
        addOtherWhitePiece(Piece.createWhiteKnight());
        addOtherWhitePiece(Piece.createWhiteRook());
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
            return getPiecesToString(otherWhitePieces);
        else
            return getPiecesToString(otherBlackPieces);
    }

    private String getPiecesToString(List<Piece> pieces) {
        return pieces.stream()
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

}
