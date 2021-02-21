package net.honux.chess.core;

import net.honux.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.honux.chess.entity.pieces.Piece.*;

public class Pieces {

    private final List<Piece> pieceList = new ArrayList<>();

    public static Pieces createWhitePawns() {
        Pieces pieces = new Pieces();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            pieces.add(createWhitePawn());
        }
        return pieces;
    }

    public static Pieces createBlackPawns() {
        Pieces pieces = new Pieces();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            pieces.add(createBlackPawn());
        }
        return pieces;
    }

    public static Pieces createWhitePiecesExceptPawns() {
        return new Pieces()
                .add(createWhiteRook())
                .add(createWhiteKnight())
                .add(createWhiteBishop())
                .add(createWhiteQueen())
                .add(createWhiteKing())
                .add(createWhiteBishop())
                .add(createWhiteKnight())
                .add(createWhiteRook());
    }

    public static Pieces createBlackPiecesExceptPawns() {
        return new Pieces()
                .add(createBlackRook())
                .add(createBlackKnight())
                .add(createBlackBishop())
                .add(createBlackQueen())
                .add(createBlackKing())
                .add(createBlackBishop())
                .add(createBlackKnight())
                .add(createBlackRook());
    }

    public Pieces add(Piece piece) {
        if (validateSize()) {
            throw new IndexOutOfBoundsException("더 이상 Piece 를 추가할 수 없습니다.");
        }
        pieceList.add(piece);
        return this;
    }

    public int size() {
        return pieceList.size();
    }

    public Piece get(int index) {
        return pieceList.get(index);
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();
        for (Piece p : this.pieceList) {
            sb.append(p.getRepresentation());
        }
        return sb.toString();
    }

    private boolean validateSize() {
        return this.size() >= 8;
    }

}
