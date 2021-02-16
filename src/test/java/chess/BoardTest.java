package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("폰이 제대로 생성되는지 확인한다.")
    public void create() {
        board.addWhitePawn(new Pawn(Color.WHITE));
        board.addBlackPawn(new Pawn(Color.BLACK));

        assertAll(
                () -> assertEquals(1, board.whitePawnSize()),
                () -> assertEquals(1, board.blackPawnSize()),
                () -> assertEquals("white",board.getWhitePawn(0).getColor()),
                () -> assertEquals("black",board.getBlackPawn(0).getColor())

        );
    }

    @Test
    @DisplayName("폰이 제대로 생성되었는지 확인한다.")
    public void initialize() {
        board.initialize();

        assertAll(
                () -> assertEquals("pppppppp", board.getWhitePawnsResult()),
                () -> assertEquals("PPPPPPPP", board.getBlackPawnsResult())
        );
    }
}
