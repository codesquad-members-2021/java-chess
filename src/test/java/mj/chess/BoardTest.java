package mj.chess;

import mj.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static mj.chess.pieces.Pawn.Color.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {
    Board board;

    @BeforeEach
    public void beforeAll(){
        board = new Board();
    }

    @Test
    @DisplayName("보드 객체 내 흰색 폰 1개, 검은색 폰 1개 생성")
    public void create_board() {
        check_validity_of_pawn(new Pawn(WHITE.name()), 1, 0);
        check_validity_of_pawn(new Pawn(BLACK.name()), 2, 1);
    }

    public void check_validity_of_pawn(Pawn pawn, int size, int index){
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(pawn).isEqualTo(board.findPawn(index));
    }
}
