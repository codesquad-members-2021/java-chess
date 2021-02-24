package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.PieceFactory;

public class BoardTestBase {
    PieceFactory blackPieceFactory = new PieceFactory(Color.BLACK);
    PieceFactory whitePieceFactory = new PieceFactory(Color.WHITE);
}
