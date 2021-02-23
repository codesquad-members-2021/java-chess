package net.tree.chess;

import net.tree.pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


class BoardTest {

    Board board;

    @BeforeEach
    void makeNewBoard() {
        board = new Board();
    }

    @DisplayName("하얀색, 검정색 pawn 만들기")
    @Test
    void createWhitePawnAndBlackPawn() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.addPawntopawnList(white);
        Assertions.assertAll(
            () -> assertThat(board.checkPawnSize()).isEqualTo(1),
            () -> assertThat(board.findPawn(0)).isEqualTo(white)
        );

        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.addPawntopawnList(black);
        Assertions.assertAll(
                () -> assertThat(board.checkPawnSize()).isEqualTo(2),
                () -> assertThat(board.findPawn(1)).isEqualTo(black)
        );
    }


    @DisplayName("보드 초기화 및 그리기")
    @Test
    void initializeBoardAndAppend() {
        board.initialize();
        board.appendBoardWithPawns();
    }

    @DisplayName("보드 초기화하기")
    @Test
    void initializeBoard() {
        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getPawnsResult(Pawn.WHITE_REPRESENTATION));
        assertThat("PPPPPPPP").isEqualTo(board.getPawnsResult(Pawn.BLACK_REPRESENTATION));

    }

    @DisplayName("whitePawn과 blackPawn 1개씩으로 pawnList 확인해보기 ")
    @Test
    void checkPawnListWithWhitePawnAndBlackPawn() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.addPawntopawnList(white);
        assertThat(board.checkPawnSize()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.addPawntopawnList(black);
        assertThat(board.checkPawnSize()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }

}

