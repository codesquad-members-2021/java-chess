package net.nas.chess;

import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.Pawn;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
    입력 패러미터는 실제 체스판에서의 인덱스를 사용한다.
    예를들면, 실제 체스판에서 랭크의 인덱스는 1부터 8까지이다.
    그래서 흰색 폰의 랭크는 2가 된다.
    하지만 2차원 배열에서의 흰색 폰의 랭크는 1이므로, -1을 해줘야 한다.
    그래서 Board클래스에서 chessCells에 접근할때, 입력패러미터 -1을 해준다.
    ex : return chessCells[rankIdx - 1][fileIdx - 1].getOccupiedPiece();
 */
public class Board {
    public static final int LENGTH_OF_BOARD = 8;

    public static final int RANK_OF_WHITE_KING = 1;
    public static final int RANK_OF_WHITE_PAWNS = 2;
    public static final int RANK_OF_BLANK_1 = 3;
    public static final int RANK_OF_BLANK_2 = 4;
    public static final int RANK_OF_BLANK_3 = 5;
    public static final int RANK_OF_BLANK_4 = 6;
    public static final int RANK_OF_BLACK_PAWNS = 7;
    public static final int RANK_OF_BLACK_KING = 8;

    private final Pawn[][] chessCells;
    private int numberOfPieces = 0;

    public Board() {
        chessCells = new Pawn[LENGTH_OF_BOARD][LENGTH_OF_BOARD];
    }

    public void initialize() {
        for (int i = 1; i <= LENGTH_OF_BOARD; i++) {
            add(new Pawn(), RANK_OF_WHITE_PAWNS, i);
            add(new Pawn(ColorOfChessPiece.BLACK), RANK_OF_BLACK_PAWNS, i);

            add(new Pawn(ColorOfChessPiece.BLANK), RANK_OF_BLANK_1, i);
            add(new Pawn(ColorOfChessPiece.BLANK), RANK_OF_BLANK_2, i);
            add(new Pawn(ColorOfChessPiece.BLANK), RANK_OF_BLANK_3, i);
            add(new Pawn(ColorOfChessPiece.BLANK), RANK_OF_BLANK_4, i);

            add(new Pawn(ColorOfChessPiece.BLANK), RANK_OF_BLACK_KING, i);
            add(new Pawn(ColorOfChessPiece.BLANK), RANK_OF_WHITE_KING, i);
        }
    }

    public String getRepresentationOfBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = LENGTH_OF_BOARD - 1; i >= 0; i--) {
            sb.append(getRepresentationOfRank(i));
            if (i != 0)
                sb.append("\n");
        }
        return sb.toString();
    }

    private String getRepresentationOfRank(int rankIdx) {
        return Arrays.stream(chessCells[rankIdx])
                .map(Pawn::getRepresentation)
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return getRepresentationOfRank(RANK_OF_WHITE_PAWNS - 1);
    }

    public String getBlackPawnsResult() {
        return getRepresentationOfRank(RANK_OF_BLACK_PAWNS - 1);
    }

    public Pawn findPawn(int rankIdx, int fileIdx) {
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        return chessCells[rankIdx - 1][fileIdx - 1];
    }

    private boolean isInvalidIdx(int idx) {
        return 1 > idx || idx > LENGTH_OF_BOARD;
    }

    public void add(Pawn piece, int rankIdx, int fileIdx) {
        if (piece == null)
            throw new InvalidParameterException("Null value cannot be added in Board");
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        chessCells[rankIdx - 1][fileIdx - 1] = piece;
        if (piece.getColor() != ColorOfChessPiece.BLANK)
            numberOfPieces++;
    }

    public int size() {
        return numberOfPieces;
    }
}
