package net.honux.chess.attribute;

import net.honux.chess.core.Board;
import net.honux.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.honux.chess.entity.pieces.Piece.*;

public class Rank {

    private final List<Piece> pieceList = new ArrayList<>();

    public static Rank createWhitePawns() {
        Rank RANK = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            RANK.add(createWhitePawn());
        }
        return RANK;
    }

    public static Rank createBlackPawns() {
        Rank RANK = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            RANK.add(createBlackPawn());
        }
        return RANK;
    }

    public static Rank createWhitePiecesExceptPawns() {
        return new Rank()
                .add(createWhiteRook())
                .add(createWhiteKnight())
                .add(createWhiteBishop())
                .add(createWhiteQueen())
                .add(createWhiteKing())
                .add(createWhiteBishop())
                .add(createWhiteKnight())
                .add(createWhiteRook());
    }

    public static Rank createBlackPiecesExceptPawns() {
        return new Rank()
                .add(createBlackRook())
                .add(createBlackKnight())
                .add(createBlackBishop())
                .add(createBlackQueen())
                .add(createBlackKing())
                .add(createBlackBishop())
                .add(createBlackKnight())
                .add(createBlackRook());
    }

    public void putPiece(int index, Piece piece) {
        this.pieceList.set(index, piece);
    }

    public static Rank createBlankPieces() {
        Rank blankRank = new Rank();
        for(int i = 0; i < Board.BOARD_SIZE; i++) {
            blankRank.add(createBlank());
        }
        return blankRank;
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

    public int countOfBlackPieces() {
        return (int) pieceList.stream().filter(piece -> Character.isUpperCase(piece.getRepresentation())).count();
    }

    public int countOfWhitePieces() {
        return (int) pieceList.stream().filter(piece -> piece.getRepresentation() != '.').filter(piece -> Character.isLowerCase(piece.getRepresentation())).count();
    }

    public int countOfPiece(Color color, Type type) {
        return (int) pieceList.stream().filter(piece -> piece.getRepresentation() == type.getRepresentation(color)).count();
    }

    private void validateSize() {
        if(this.size() >= Board.BOARD_SIZE) {
            throw new IndexOutOfBoundsException("더 이상 Piece 를 추가할 수 없습니다.");
        }
    }

    private Rank add(Piece piece) {
        validateSize();
        pieceList.add(piece);
        return this;
    }

}
