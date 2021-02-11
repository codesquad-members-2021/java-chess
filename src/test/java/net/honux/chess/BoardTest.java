package net.honux.chess;

import net.honux.pieces.Pawn;
import org.junit.jupiter.api.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        this.board = new Board();
    }

    @Test
    @DisplayName("보드 위에 폰 추가하고 추가된 폰이 보드에 정상적으로 반영되어야 한다.")
    void add_폰이_보드에_정상적으로_추가되는지_확인() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        addPawnAndCheckTheBoard(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        addPawnAndCheckTheBoard(black);
    }

    @Test
    @DisplayName("폰이 아닌 객체를 보드에 추가할 시 컴파일 에러가 발생해야 한다.")
    void add_보드위에_폰이_아닌_객체추가() {
        Object notPawn = new Object();
        board.add(notPawn);
    }

    private void addPawnAndCheckTheBoard(Pawn pawn) {
        int sizeBeforeAddThePawn = board.size();
        board.add(pawn);
        Assertions.assertEquals(sizeBeforeAddThePawn + 1, board.size());
        Assertions.assertEquals(pawn, board.findPawn(sizeBeforeAddThePawn));
    }

}
