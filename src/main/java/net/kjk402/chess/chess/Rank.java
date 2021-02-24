package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Piece.*;
import net.kjk402.chess.pieces.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank {
    private static final int BOARD_SIZE = 8;
    private static List<Piece> pieceList = new ArrayList<>(BOARD_SIZE);

    private static void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public Piece getPiece(int rankIndex) {
        return pieceList.get(rankIndex);
    }

    public static Rank setWhitePieces(int index) {
        Rank rank = new Rank();
        addPiece(Piece.createWhiteRook(new Position(0, index)));
        addPiece(Piece.createWhiteKnight(new Position(1, index)));
        addPiece(Piece.createWhiteBishop(new Position(2, index)));
        addPiece(Piece.createWhiteQueen(new Position(3, index)));
        addPiece(Piece.createWhiteKing(new Position(4, index)));
        addPiece(Piece.createWhiteBishop(new Position(5, index)));
        addPiece(Piece.createWhiteKnight(new Position(6, index)));
        addPiece(Piece.createWhiteRook(new Position(7, index)));
        return rank;
    }

    public static Rank setBlackPieces(int index) {
        Rank rank = new Rank();
        addPiece(Piece.createBlackRook(new Position(0, index)));
        addPiece(Piece.createBlackKnight(new Position(1, index)));
        addPiece(Piece.createBlackBishop(new Position(2, index)));
        addPiece(Piece.createBlackQueen(new Position(3, index)));
        addPiece(Piece.createBlackKing(new Position(4, index)));
        addPiece(Piece.createBlackBishop(new Position(5, index)));
        addPiece(Piece.createBlackKnight(new Position(6, index)));
        addPiece(Piece.createBlackRook(new Position(7, index)));
        return rank;
    }

    public static Rank setWhitePawns(int index) {
        Rank rank = new Rank();
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createWhitePawn(new Position(i, index)));
        }
        return rank;
    }

    public static Rank setBlackPawns(int index) {
        Rank rank = new Rank();
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createBlackPawn(new Position(i, index)));
        }
        return rank;
    }

    public static Rank setBlackLine(int index) {
        Rank rank = new Rank();
        for(int i =0; i< BOARD_SIZE; i++) {
            addPiece(Piece.createBlank(new Position(i, index)));
        }
        return rank;
    }

    public int countPiece(Color color, Type type) {
        int count = 0;
        for (Piece piece : pieceList) {
            if (piece.getColor() == color && piece.getType() == type) {
                count++;
            }
        }
        return count;
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

}
