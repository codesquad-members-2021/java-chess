package net.woody.factories;

import net.woody.chess.Board;
import net.woody.chess.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.woody.chess.Board.*;
import static net.woody.factories.RankFactory.*;
import static net.woody.factories.RankFactory.createBlackPieceRank;

public class BoardFactory {

    private static final int BOARD_LENGTH = 8;

    public static Board createEmtpyBoard() {
        List<Rank> board = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            board.add(i, createBlankRank());
        }
        return createBoard(board);
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
        return createBoard(initBoard);
    }
}
