package kr.codesquad.freddie.chess.game;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;
import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class ChessGame {
    private Board board;
    private boolean isInitialized;

    private ChessGame(Board board) {
        this.board = board;
    }

    public static ChessGame create() {
        return new ChessGame(new Board());
    }

    public void initialize() {
        if (isInitialized) {
            throw new IllegalStateException("게임이 이미 시작되었습니다.");
        }

        board.initializePieceBy(Color.BLACK);
        board.initializeEmptyPiece();
        board.initializePieceBy(Color.WHITE);
        isInitialized = true;
    }

    public void move(String source, String target) {
        if (!isInitialized) {
            throw new IllegalStateException("게임이 시작되지 않았습니다.");
        }

        Piece sourcePiece = board.findPiece(source);
        Piece targetPiece = board.findPiece(target);
        if (sourcePiece.getColor() == targetPiece.getColor()) {
            String message = "이동 위치의 기물이 같은 색상입니다. source : " + sourcePiece + ", target : " + targetPiece;
            throw new IllegalArgumentException(message);
        }

        if (!sourcePiece.isCanMove(new PositionCalculator(Position.of(source), Position.of(target)), targetPiece)) {
            String message = "이동 위치가 올바르지 않습니다. : source : " + source + ", target : " + target;
            throw new IllegalArgumentException(message);
        }

        board.set(target, sourcePiece);
        board.set(source, PieceFactory.createBlank());
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
