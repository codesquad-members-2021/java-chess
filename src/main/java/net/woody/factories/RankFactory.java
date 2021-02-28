package net.woody.factories;

import net.woody.chess.Rank;
import net.woody.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.woody.chess.Rank.*;
import static net.woody.factories.PieceFactory.*;

public class RankFactory {

    private static final int BOARD_LENGTH = 8;

    public static Rank createBlankRank() {
        ArrayList<Piece> pieces = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(getBlankInstance());
        }
        return createRank(pieces);
    }

    public static Rank createWhitePawnRank() {
        ArrayList<Piece> pieces = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(createWhitePawn());
        }
        return createRank(pieces);
    }

    public static Rank createBlackPawnRank() {
        ArrayList<Piece> pieces = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(createBlackPawn());
        }
        return createRank(pieces);
    }

    public static Rank createBlackPieceRank() {
        return createRank(blackPieces());
    }

    public static Rank createWhitePieceRank() {
        return createRank(whitePieces());
    }

    private static List<Piece> blackPieces() {
        return Stream.of(
                createBlackRook(),
                createBlackKnight(),
                createBlackBishop(),
                createBlackQueen(),
                createBlackKing(),
                createBlackBishop(),
                createBlackKnight(),
                createBlackRook()
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<Piece> whitePieces() {
        return Stream.of(
                createWhiteRook(),
                createWhiteKnight(),
                createWhiteBishop(),
                createWhiteQueen(),
                createWhiteKing(),
                createWhiteBishop(),
                createWhiteKnight(),
                createWhiteRook()
        ).collect(Collectors.toCollection(ArrayList::new));
    }
}
