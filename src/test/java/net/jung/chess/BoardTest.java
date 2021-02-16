package net.jung.chess;

import net.jung.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {

    private Board board;
    private Pawn whitePawn;
    private Pawn blackPawn;

    @BeforeEach
    void setUp(){
        board = new Board();
        whitePawn = new Pawn(Color.WHITE);
        blackPawn = new Pawn(Color.BLACK);

    }
    @Test
    @DisplayName("보드를 생성하고 흰색 검은색 폰을 추가한 후 size, findPawn 메서드 검증한다.")
    void createBoardAddPawns() throws Exception{

        assertAll(
                () -> {
                    board.add(whitePawn);
                    assertAll("흰색 폰을 보드에 올린 후 size, findPawn메서드 검증한다.",
                            () -> assertThat(board.size()).isEqualTo(1),
                            () -> assertThat(board.findWhitePawn(0)).isEqualTo(whitePawn));
                },
                () -> {
                    board.add(blackPawn);
                    assertAll("검은색 폰을 보드에 올린 후 size, findPawn메서드 검증한다.",
                            () -> assertThat(board.size()).isEqualTo(2),
                            () -> assertThat(board.findBlackPawn(0)).isEqualTo(blackPawn));
                }
        );

    }



}
