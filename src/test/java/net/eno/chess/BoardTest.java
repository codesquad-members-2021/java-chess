package net.eno.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import net.eno.pieces.Piece;
import net.eno.pieces.Color;
import net.eno.pieces.Representation;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
    }

    @Test
    @DisplayName("폰을 추가 시 전체 사이즈와 해당 인덱스의 폰이 일치해야 한다.")
    public void create() {
        verifyPawnSize(Color.WHITE, Representation.PAWN, 1, 0);
        verifyPawnSize(Color.WHITE, Representation.PAWN, 2, 1);
        verifyPawnSize(Color.BLACK, Representation.PAWN, 1, 0);
        verifyPawnSize(Color.BLACK, Representation.PAWN, 2, 1);
    }

    public void verifyPawnSize(Color color, Representation representation, int size, int index) {
        Piece piece = Piece.createPiece(color, representation);
        board.addPiece(color, piece);
        assertThat(board.pieceSize(color)).isEqualTo(size);
        assertThat(board.findPiece(color, index)).isEqualTo(piece);
    }

    @Test
    @DisplayName("보드를 초기화한 결과 흰색 폰과 검은색 폰의 열이 각각 일치해 한다.")
    public void initialize() {
        board.initialize();
        assertThat(board.getPiecesResult(Color.WHITE)).isEqualTo("pppppppp");
        assertThat(board.getPiecesResult(Color.BLACK)).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("초기화 된 보드가 출력되어야 한다.")
    public void print() {
        board.initialize();
        board.print();
    }

}
