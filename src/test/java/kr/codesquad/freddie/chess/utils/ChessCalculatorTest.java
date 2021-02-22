package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChessCalculatorTest {
    private ChessCalculator chessCalculator = new ChessCalculator();
    private PieceFactory blackPieceFactory = new PieceFactory(Color.BLACK);

    @Test
    void calculate() {
        Board board = new Board();

        for (int i = 0; i < 64; i++) {
            board.add(Piece.createBlank());
        }

        board.set("a1", blackPieceFactory.createPawn());
        board.set("a2", blackPieceFactory.createPawn());
        board.set("a3", blackPieceFactory.createPawn());

        double result = new ChessCalculator().calculateScore(board, Color.BLACK);
        assertThat(result).isEqualTo(1.5);
    }
}
