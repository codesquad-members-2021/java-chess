package mj.chess;

import mj.chess.pieces.ColorOfPiece;
import mj.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardTest {
    Board board;

    @BeforeEach
    void setup(){
        board = new Board();
    }

    @Test
    @DisplayName("보드 객체 내 흰색 폰 1개, 검은색 폰 1개 생성")
    void createBoard() {
        Pawn blackPawn = new Pawn(ColorOfPiece.BLACK);
        Pawn whitePawn = new Pawn();

        verifyAddition(blackPawn, 1);
        verifyAddition(whitePawn, 2);
        verifySearchByIndex(blackPawn, 0);
        verifySearchByIndex(whitePawn, 1);
    }

    void verifyAddition(Pawn pawn, int size){
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
    }
    void verifySearchByIndex(Pawn pawn, int index){
        assertThat(pawn).isEqualTo(board.findPawn(index));
    }
}
