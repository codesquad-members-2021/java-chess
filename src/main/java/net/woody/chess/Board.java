package net.woody.chess;

import static net.woody.utils.StringUtils.appendNewLine;

import net.woody.pieces.Piece;
import net.woody.pieces.Piece.Color;
import net.woody.pieces.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.woody.factories.PieceFactory.*;
import static net.woody.factories.RankFactory.*;

public class Board {

    private static final int BOARD_LENGTH = 8;
    private static final int ASCII_LOWERCASE = 97;
    private static final int ASCII_CHARINT = 48;

    private final List<Rank> board;

    private Board(List<Rank> board) {
        this.board = board;
    }

    // TODO : position 문자열 → Position 클래스 구현
    public void move(String position, Piece piece) {
        int file = position.charAt(0) - ASCII_LOWERCASE;
        int rank = position.charAt(1) - ASCII_CHARINT - 1;
        getRank(rank).add(file, piece);
    }

    public Piece findPiece(String position) {
        int file = position.charAt(0) - ASCII_LOWERCASE;
        int rank = position.charAt(1) - ASCII_CHARINT - 1;
        return findPiece(file, rank);
    }

    public Piece findPiece(int file, int rank) {
        return getRank(rank).getPiece(file);
    }

    public int numOfSpecificPiece(Color color, Type type) {
        Piece target = getBlankInstance();
        target = (color == Color.BLACK) ? Piece.createBlack(type) : target;
        target = (color == Color.WHITE) ? Piece.createWhite(type) : target;

        int targetCounter = 0;
        for (int rank = 0; rank < BOARD_LENGTH; rank++) {
            targetCounter += getRank(rank).getNumOfPiece(target);
        }
        return targetCounter;
    }

    public static Board createEmtpyBoard() {
        List<Rank> board = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(i, createBlankRank());
        }
        return new Board(board);
    }

    public static Board createInitBoard() {
        List<Rank> initBoard = Stream.of(
                createWhitePieceRank(),
                createWhitePawnRank(),
                createBlankRank(),
                createBlankRank(),
                createBlankRank(),
                createBlankRank(),
                createBlackPawnRank(),
                createBlackPieceRank()
        ).collect(Collectors.toCollection(ArrayList::new));
        return new Board(initBoard);
    }

    private Rank getRank(int rank) {
        validateRank(rank);
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


    public double calculatePoint(Color color) {
        double score = 0;
        for (int file = 0; file < BOARD_LENGTH; file++) {
            score += calculateOneFileLine(color, file);
        }

        return score;
    }

    private double calculateOneFileLine(Color color, int file) {
        int score = 0;
        int pawnCounter = 0;
        for (int rank = 0; rank < BOARD_LENGTH; rank++) {
            Piece piece = findPiece(file, rank);
            if (piece.getColor() == color) {
                score += piece.getType().getDefaultPoint();
                if (piece.isPawn()) {
                    pawnCounter++;
                }
            }
        }
        score -= (pawnCounter > 1) ? pawnCounter * 0.5 : 0;
        return score;
    }

    private void validateRank(int rank) {
        if (rank < 0 || board.size() <= rank) {
            throw new ArrayIndexOutOfBoundsException("Rank number " + rank + " is out of range!");
        }
    }

    @Override
    public String toString() {
        StringBuilder boardState = new StringBuilder();
        for (int i = BOARD_LENGTH - 1; i >= 0; i--) {
            boardState.append(appendNewLine(getRank(i).toString()));
        }

        return boardState.toString();
    }

}
