package net.woody.chess;

import static net.woody.utils.StringUtils.appendNewLine;

import net.woody.pieces.Piece;
import net.woody.pieces.Piece.Color;
import net.woody.pieces.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private final List<Rank> board;

    private Board(List<Rank> board) {
        this.board = board;
    }

    public void add(Piece piece, int rank, int file) {
        getRank(rank).add(file, piece);
    }

    public Piece findPiece(int rank, int file) {
        return getRank(rank).getPiece(file);
    }

    public int numOfSpecificPiece(Color color, Type type) {
        Piece target = Piece.getBlankInstance();
        target = (color == Color.BLACK) ? Piece.createBlack(type) : target;
        target = (color == Color.WHITE) ? Piece.createWhite(type) : target;

        int targetCounter = 0;
        for (int rank = 0; rank < BOARD_LENGTH; rank++) {
            targetCounter += getRank(rank).getNumOfPiece(target);
        }
        return targetCounter;
    }


    public static Board createBlankBoard() {
        List<Rank> board = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(i, Rank.createBlankRank());
        }
        return new Board(board);
    }

    public static Board createInitBoard() {
        List<Rank> initBoard = Stream.of(
                Rank.createBlackPieceRank(),
                Rank.createBlackPawnRank(),
                Rank.createBlankRank(),
                Rank.createBlankRank(),
                Rank.createBlankRank(),
                Rank.createBlankRank(),
                Rank.createWhitePawnRank(),
                Rank.createWhitePieceRank()
        ).collect(Collectors.toCollection(ArrayList::new));
        return new Board(initBoard);
    }

    private Rank getRank(int rank) {
        if (rank < 0 || board.size() <= rank) {
            throw new ArrayIndexOutOfBoundsException("Rank number " + rank + " is out of range!");
        }
        return board.get(rank);
    }

    // TODO : 더 효율적인 방식 고려
    public int size() {
        int numOfPieces = 0;
        for (Rank rank : board) {
            numOfPieces += rank.size();
        }
        return numOfPieces;
    }

    // TODO : 네이밍 수정 혹은 toString 오버라이드
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board) {
            sb.append(appendNewLine(rank.toString()));
        }
        return sb.toString();
    }
}
