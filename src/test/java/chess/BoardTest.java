package chess;

import net.nas.chess.Board;
import net.nas.chess.ColorOfChessPiece;
import net.nas.chess.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    @DisplayName("체스 보드에 폰을 추가하고, 찾을 수 있어야 합니다.")
    void testAdditionAndFind() {
        Board board = new Board();
        Pawn whitePawn = new Pawn();
        Pawn blackPawn = new Pawn(ColorOfChessPiece.BLACK);

        board.add(whitePawn);
        assertThat(board.findPawn(0)).isEqualTo(whitePawn);
        assertThat(board.size()).isEqualTo(1);

        board.add(blackPawn);
        assertThat(board.findPawn(1)).isEqualTo(blackPawn);
        assertThat(board.size()).isEqualTo(2);
    }
}
