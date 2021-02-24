package net.kjk402.chess.pieces;

import ch.qos.logback.core.BasicStatusManager;

import java.util.ArrayList;
import java.util.List;
import static net.kjk402.chess.utils.StringUtils.appendNewLine;

public class Rank {
    private static final int BOARD_SIZE = 8;
    private static List<Piece> pieceList = new ArrayList<>();

    private static void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    public static Rank setWhitePieces() {
        Rank rank = new Rank();
        addPiece(Piece.createWhiteRook());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteQueen());
        addPiece(Piece.createWhiteKing());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteRook());
        return rank;
    }

    public static Rank setBlackPieces() {
        Rank rank = new Rank();
        addPiece(Piece.createBlackRook());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackQueen());
        addPiece(Piece.createBlackKing());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackRook());
        return rank;
    }

    public static Rank setWhitePawns() {
        Rank rank = new Rank();
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createWhitePawn());
        }
        return rank;
    }

    public static Rank setBlackPawns() {
        Rank rank = new Rank();
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createBlackPawn());
        }
        return rank;
    }

    public static Rank setBlackLine() {
        Rank rank = new Rank();
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createBlank());
        }
        return rank;
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
