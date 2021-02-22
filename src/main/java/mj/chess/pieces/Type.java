package mj.chess.pieces;

import mj.chess.Board;

import java.util.function.BiConsumer;

public enum Type {
    BISHOP("b", (board, color) -> {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteBishop()
                : Piece.PieceMaker.createBlackBishop();

        for (int i = 0; i < 2; i++) {
            board.addPiece(piece);
        }
    }),
    KING("k", (board, color) -> {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteKing()
                : Piece.PieceMaker.createBlackKing();

        for (int i = 0; i < 1; i++) {
            board.addPiece(piece);
        }
    }),
    KNIGHT("n", (board, color) -> {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteKnight()
                : Piece.PieceMaker.createBlackKnight();

        for (int i = 0; i < 2; i++) {
            board.addPiece(piece);
        }
    }),
    PAWN("p", (board, color) -> {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhitePawn()
                : Piece.PieceMaker.createBlackPawn();

        for (int i = 0; i < 8; i++) {
            board.addPiece(piece);
        }
    }),
    QUEEN("q", (board, color) -> {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteQueen()
                : Piece.PieceMaker.createBlackQueen();

        for (int i = 0; i < 1; i++) {
            board.addPiece(piece);
        }
    }),
    ROOK("r", (board, color) -> {
        Piece piece = (color == Color.WHITE)
                ? Piece.PieceMaker.createWhiteRook()
                : Piece.PieceMaker.createBlackRook();

        for (int i = 0; i < 2; i++) {
            board.addPiece(piece);
        }
    });

    private final String representation;

    private BiConsumer<Board, Color> expression;

    Type(String representation, BiConsumer<Board, Color> expression) {
        this.representation = representation;
        this.expression = expression;
    }

    public void initPiece(Board board, Color color) {
        this.expression.accept(board, color);
    }

    public String getRepresentation(Color color) {
        if (color == Color.BLACK) {
            return representation.toUpperCase();
        }

        return representation;
    }
}
