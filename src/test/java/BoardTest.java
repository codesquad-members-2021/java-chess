import net.sanhee.chess.*;
import net.sanhee.pieces.Pawn;
import net.sanhee.pieces.UnitColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    static public Board board = new Board();

    @Test
    @DisplayName("흰색 Pawn을 체스 판, 첫번째 칸에 추가")
    public void create() throws Exception {
        spawnPawn(UnitColor.WHITE, 1);
    }

    @Test
    @DisplayName("흑색 Pawn을 체스 판, 두번째 칸에 추가")
    public void create2() throws Exception {
        spawnPawn(UnitColor.BLACK, 2);
    }

    /*
        @Deprecated
        @DisplayName("체스 판에 Pawn 이외의 객체가 추가되지 않도록 한다.")

        public void otherUnitCheck(){
            Integer testInteger = new Integer("7");
            board.add(testInteger);

            spawnCheck(testInteger,3);
        }
    */
    private void spawnPawn(UnitColor color, int order) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        spawnCheck(pawn, order);
    }

    private void spawnCheck(Pawn object, int order) {
        assertAll(
                //A Case
                () -> assertThat(board.size()).isEqualTo(order),
                //B Case
                () -> assertThat(board.findPawn(order - 1)).isEqualTo(object)
        );
    }

}