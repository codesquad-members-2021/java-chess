package net.woody.chess;

import static net.woody.utils.StringUtils.appendNewLine;

import net.woody.pieces.Piece;

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

    public Rank getRank(int rank) {
        if (rank < 0 || board.size() <= rank) {
            throw new ArrayIndexOutOfBoundsException("Rank number " + rank + " is out of range!");
        }
        return board.get(rank);
    }

    public Piece findPiece(int rank, int file) {
        return getRank(rank).find(file);
    }

    public static Board createInitBoard() {
        return new Board(initialize());
    }

    public static Board createBlankBoard() {
        List<Rank> board = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(i, Rank.createBlankRank());
        }
        return new Board(board);
    }

    private static List<Rank> initialize() {
        return Stream.of(
                Rank.createBlackPieceRank(),
                Rank.createBlackPawnRank(),
                Rank.createBlankRank(),
                Rank.createBlankRank(),
                Rank.createBlankRank(),
                Rank.createBlankRank(),
                Rank.createWhitePawnRank(),
                Rank.createWhitePieceRank()
        ).collect(Collectors.toCollection(ArrayList::new));
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
