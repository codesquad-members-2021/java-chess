package kr.codesquad.freddie.chess;

import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;

public class ChessTestBase {
    protected static final int MAX_SIZE = Board.RANK_SIZE * File.SIZE;
    protected PieceFactory blackPieceFactory = new PieceFactory(Color.BLACK);
    protected PieceFactory whitePieceFactory = new PieceFactory(Color.WHITE);

    protected void initBoard(Board board) {
        board.initializePieceBy(Color.BLACK);
        board.initializeEmptyPiece();
        board.initializePieceBy(Color.WHITE);
    }

    protected void initBoardWithBlank(Board board) {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(Piece.EMPTY_PIECE);
        }
    }
}
