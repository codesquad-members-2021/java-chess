package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

import static utils.StringUtils.appendNewLine;

class Rank {
    private static final int BOARD_SIZE = 8;
    private static final String BLANK_LINE = "........";

    private final List<Piece> pieces = new ArrayList<>(BOARD_SIZE);

    void addPiece(Piece piece) {
        pieces.add(piece);
    }

    List<Piece> getPieces() {
        return pieces;
    }

    int countPieces(Color color, Type type) {
        int countPiece = 0;
        for (Piece piece : pieces) {
            if (piece.verifyPiece(color, type)) {
                countPiece++;
            }
        }
        return countPiece;
    }

    static Rank initializeWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteQueen());
        rank.addPiece(Piece.createWhiteKing());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteRook());
        return rank;
    }

    static Rank initializeBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackQueen());
        rank.addPiece(Piece.createBlackKing());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackRook());
        return rank;
    }

    static Rank initializeWhitePawns() {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
        return rank;
    }

    static Rank initializeBlackPawns() {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlackPawn());
        }
        return rank;
    }

    static Rank initializeBlankLine() {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlank());
        }
        return rank;
    }

    public int size() {
        return pieces.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : getPieces()) {
            sb.append(piece.getRepresentation());
        }
        return appendNewLine(sb.toString());
    }
}