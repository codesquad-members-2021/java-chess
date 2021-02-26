package kr.codesquad.freddie.chess;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.File;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.PieceFactory;

public class ChessTestBase {
    protected static final int MAX_SIZE = Board.RANK_SIZE * File.SIZE;
    protected PieceFactory blackPieceFactory = new PieceFactory(Color.BLACK);
    protected PieceFactory whitePieceFactory = new PieceFactory(Color.WHITE);
}
