package net.kjk402.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private static final int BOARD_SIZE = 8;
    private List<Piece> pieceList = new ArrayList<>();

    private void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    private void setWhitePieces() {
        addPiece(Piece.createWhiteRook());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteQueen());
        addPiece(Piece.createWhiteKing());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteRook());
    }

    private void setBlackPieces() {
        addPiece(Piece.createBlackRook());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackQueen());
        addPiece(Piece.createBlackKing());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackRook());
    }

    private void setWhitePawns() {
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createWhitePawn());
        }
    }

    private void setBlackPawns() {
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createBlackPawn());
        }
    }

    private void setBlackLine() {
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createBlank());
        }
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public String getBoard() {
        setBlackPieces();
        setBlackPawns();
        setBlackLine();
        setBlackLine();
        setBlackLine();
        setBlackLine();
        setWhitePawns();
        setWhitePieces();
        return getPiecesResult(pieceList);
    }

}
