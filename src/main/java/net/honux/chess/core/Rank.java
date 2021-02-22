package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Type;
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

    public static Rank createARank() {
        return new Rank()
                .add(createBlackRook())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteRook());
    }

    public static Rank createBRank() {
        return new Rank()
                .add(createBlackKnight())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteKnight());
    }

    public static Rank createCRank() {
        return new Rank()
                .add(createBlackBishop())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteBishop());
    }

    public static Rank createDRank() {
        return new Rank()
                .add(createBlackQueen())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteQueen());
    }

    public static Rank createERank() {
        return new Rank()
                .add(createBlackKing())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteKing());
    }

    public static Rank createFRank() {
        return new Rank()
                .add(createBlackBishop())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteBishop());
    }


    public static Rank createGRank() {
        return new Rank()
                .add(createBlackKnight())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteKnight());
    }

    public static Rank createHRank() {
        return new Rank()
                .add(createBlackRook())
                .add(createBlackPawn())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createBlank())
                .add(createWhitePawn())
                .add(createWhiteRook());
    }

    public static Rank createBlankPieces() {
        Rank blankRank = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            blankRank.add(createBlank());
        }
        return blankRank;
    }

    public void putPiece(int index, Piece piece) {
        this.pieceList.set(index, piece);
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

    public int getPointsOfType(Color color) {
        int point = 0;
        for (Type type : Type.values()) {
            point += pieceList.stream().filter(piece -> piece.getRepresentation() == type.getRepresentation(color)).count() * type.getPoint();
        }
        return point;
    }

    private void validateSize() {
        if (this.size() >= Board.BOARD_SIZE) {
            throw new IndexOutOfBoundsException("더 이상 Piece 를 추가할 수 없습니다.");
        }
    }

    private Rank add(Piece piece) {
        validateSize();
        pieceList.add(piece);
        return this;
    }

}
