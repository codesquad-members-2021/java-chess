package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import pieces.Pawn;
import pieces.Piece;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void initialize() {
        board = new Board();
    }

    @Test
    @DisplayName("폰을 추가 시 전체 사이즈와 해당 인덱스의 폰이 일치해야 한다.")
    public void create() throws Exception {
        verifyPawnSize(Piece.PAWN_WHITE.color, Piece.PAWN_WHITE.representation, 1, 0);
        verifyPawnSize(Piece.PAWN_BLACK.color, Piece.PAWN_BLACK.representation, 2, 1);
    }

    public void verifyPawnSize(final String color, final char representation ,int size, int index) {
        Pawn pawn = new Pawn(color, representation);
        board.addPawn(pawn);
        assertThat(board.pawnSize()).isEqualTo(size);
        assertThat(board.findPawn(index)).isEqualTo(pawn);
    }

}
