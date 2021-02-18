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
    public static final int RANK_OF_WHITE_PAWNS = 2;
    public static final int RANK_OF_BLACK_PAWNS = 7;

    private ChessCell[][] chessCells;
    private int numberOfPieces = 0;

    public Board() {
        chessCells = new ChessCell[8][8];
        for (int i = 0; i < LENGTH_OF_BOARD; i++)
            for (int j = 0; j < LENGTH_OF_BOARD; j++)
                chessCells[i][j] = new ChessCell();
    }

    public void initialize() {
        for (int i = 1; i <= LENGTH_OF_BOARD; i++) {
            add(new Pawn(), RANK_OF_WHITE_PAWNS, i);
            add(new Pawn(ColorOfChessPiece.BLACK), RANK_OF_BLACK_PAWNS, i);
        }
    }

    public void print() {
        System.out.println(getResultOfAllRows());
    }

    public String getResultOfAllRows() {
        StringBuilder sb = new StringBuilder();
        for (int i = LENGTH_OF_BOARD - 1; i >= 0; i--) {
            sb.append(getResultOfRow(i));
            if (i != 0)
                sb.append("\n");
        }
        return sb.toString();
    }

    private String getResultOfRow(int rowIdx) {
        return Arrays.stream(chessCells[rowIdx])
                .map(ChessCell::getRepresentation)
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return getResultOfRow(RANK_OF_WHITE_PAWNS - 1);
    }

    public String getBlackPawnsResult() {
        return getResultOfRow(RANK_OF_BLACK_PAWNS - 1);
    }

    public Pawn findPawn(int rankIdx, int fileIdx) {
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        return chessCells[rankIdx - 1][fileIdx - 1].getOccupiedPiece();
    }

    private boolean isInvalidIdx(int idx) {
        return 1 > idx || idx > LENGTH_OF_BOARD;
    }

    public void add(Pawn piece, int rankIdx, int fileIdx) {
        if (piece == null)
            throw new InvalidParameterException("Null value cannot be added in Board");
        if (isInvalidIdx(rankIdx) || isInvalidIdx(fileIdx))
            throw new InvalidParameterException("index exceeded the bounds of the Board");
        chessCells[rankIdx - 1][fileIdx - 1].occupy(piece);
        numberOfPieces++;
    }

    public int size() {
        return numberOfPieces;
    }
}
