package mj.chess.pieces;

import mj.chess.Board;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public enum Type {
    BISHOP("b", Type::initBishopOnBoard),
    KING("k", Type::initKingOnBoard),
    KNIGHT("n", Type::initKnightOnBoard),
    PAWN("p", Type::initPawnOnBoard),
    QUEEN("q", Type::initQueenOnBoard),
    ROOK("r", Type::initRookOnBoard);

    private final String representation;

    private final BiConsumer<Board, Color> expression;

    Type(String representation, BiConsumer<Board, Color> expression) {
        this.representation = representation;
        this.expression = expression;
    }

    public String getRepresentation(Color color) {
        if (color == Color.BLACK) {
            return representation.toUpperCase();
        }

        return representation;
    }

    public void initPiece(Board board, Color color) {
        this.expression.accept(board, color);
    }

    private static void initPawnOnBoard(Board board, Color color) {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhitePawn()
                : Piece.PieceMaker.createBlackPawn();

        IntStream.range(0, 8)
                .mapToObj(i -> piece)
                .forEach(board::addPiece);
    }

    private static void initBishopOnBoard(Board board, Color color) {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteBishop()
                : Piece.PieceMaker.createBlackBishop();

        IntStream.range(0, 2)
                .mapToObj(i -> piece)
                .forEach(board::addPiece);
    }

    private static void initKnightOnBoard(Board board, Color color) {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteKnight()
                : Piece.PieceMaker.createBlackKnight();

        IntStream.range(0, 2)
                .mapToObj(i -> piece)
                .forEach(board::addPiece);
    }

    private static void initKingOnBoard(Board board, Color color) {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteKing()
                : Piece.PieceMaker.createBlackKing();

        IntStream.range(0, 1)
                .mapToObj(i -> piece)
                .forEach(board::addPiece);
    }

    private static void initQueenOnBoard(Board board, Color color) {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteQueen()
                : Piece.PieceMaker.createBlackQueen();

        IntStream.range(0, 1)
                .mapToObj(i -> piece)
                .forEach(board::addPiece);
    }

    private static void initRookOnBoard(Board board, Color color) {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteRook()
                : Piece.PieceMaker.createBlackRook();

        IntStream.range(0, 2)
                .mapToObj(i -> piece)
                .forEach(board::addPiece);
    }
}
