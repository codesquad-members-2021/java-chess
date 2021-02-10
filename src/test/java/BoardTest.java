import net.sanhee.chess.*;
import net.sanhee.chess.UnitColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    static public Board board = new Board();

    @Test
    @DisplayName("흰색 Pawn을 체스 판, 첫번째 칸에 추가")
    public void create() throws Exception {
        Pawn white = new Pawn(UnitColor.WHITE.getColor());
        board.add(white);

        assertAll(
                //A Case
                () -> assertThat(board.size()).isEqualTo(1),
                //B Case
                () -> assertThat(board.findPawn(0)).isEqualTo(white)
        );
    }
    @Test
    @DisplayName("흑색 Pawn을 체스 판, 두번째 칸에 추가")
    public void create2() throws Exception {
        Pawn black = new Pawn(UnitColor.BLACK.getColor());
        board.add(black);

        assertAll(
                //A Case
                () -> assertThat(board.size()).isEqualTo(2),
                //B Case
                () -> assertThat(board.findPawn(1)).isEqualTo(black)
        );
    }


}