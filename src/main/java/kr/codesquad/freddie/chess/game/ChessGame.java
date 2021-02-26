package kr.codesquad.freddie.chess.game;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;

public class ChessGame {
    private Board board;

    private ChessGame(Board board) {
        this.board = board;
    }

    public static ChessGame create() {
        return new ChessGame(new Board());
    }

    public void initialize() {
        board.initializePieceBy(Color.BLACK);
        board.initializeEmptyPiece();
        board.initializePieceBy(Color.WHITE);
    }

    public void move(String source, String target) {
        Piece sourcePiece = board.findPiece(source);

        if (!sourcePiece.isCanMove(Position.of(source), Position.of(target), board)) {
            String message = "이동 위치가 올바르지 않습니다. : source : " + source + ", target : " + target;
            throw new IllegalArgumentException(message);
        }

        board.set(target, sourcePiece);
        board.set(source, Piece.createBlank());
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "ChessGame{" +
                "board=" + board +
                '}';
    }
}
