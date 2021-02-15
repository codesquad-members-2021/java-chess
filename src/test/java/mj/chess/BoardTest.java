package mj.chess;

import mj.chess.pieces.ColorOfPiece;
import mj.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {
    Board board;

    @BeforeEach
    public void setup(){
        board = new Board();
    }

    @Test
    @DisplayName("보드 객체 내 흰색 폰 1개, 검은색 폰 1개 생성")
    public void createBoard() {
        verifyAddAndSearch(new Pawn(ColorOfPiece.WHITE), 1, 0);
        verifyAddAndSearch(new Pawn(ColorOfPiece.BLACK), 2, 1);
    }

    public void verifyAddAndSearch(Pawn pawn, int size, int index){
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(pawn).isEqualTo(board.findPawn(index));
    }
}
