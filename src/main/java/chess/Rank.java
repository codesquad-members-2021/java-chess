package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.*;

import java.util.ArrayList;
import java.util.List;

import static chess.Board.*;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>(8);

    private Rank() {}

    public static Rank initWhitePieceRank() {
        Rank rank = new Rank();
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());

        return rank;
    }

    public static Rank initWhitePawnRank() {
        Rank rank = new Rank();
        for (int i = 0; i < BOARD_RANK; i++) {
            rank.add(Piece.createWhitePawn());
        }
        return rank;
    }

    public static Rank initBlackPawnRank() {
        Rank rank = new Rank();
        for (int i = 0; i < BOARD_RANK; i++) {
            rank.add(Piece.createBlackPawn());
        }
        return rank;
    }

    public static Rank initBlackPieceRank() {
        Rank rank = new Rank();
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());

        return rank;
    }

    public static Rank initBlankRank() {
        Rank rank = new Rank();
        for (int i = 0; i < BOARD_FILE; i++) {
            rank.add(Piece.createBlank());
        }
        return rank;
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public void setPiece(int index, Piece piece) {
        pieceList.add(index, piece);
    }

    public void remove(int index) {
        pieceList.remove(index);
    }

    public long count(Color color, Type type) {
        return pieceList.stream()
                .filter(x -> x.getColor() == color)
                .filter(x -> x.getType() == type)
                .count();
    }
}
