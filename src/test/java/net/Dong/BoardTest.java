package net.Dong;

import net.Dong.chess.Board;
import net.Dong.chess.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import net.Dong.chess.Pawn.*;


class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    void CreatePawnTest() {
        Pawn white = new Pawn(Color.WHITE);
        Pawn black = new Pawn(Color.BLACK);
        addWhitePawnToBoard(board,white,1,0);
        addBlackPawnToBoard(board,black,2,0);
        addWhitePawnToBoard(board,white,3,1);
        addBlackPawnToBoard(board,black,4,1);
        addWhitePawnToBoard(board,white,5,2);
        addBlackPawnToBoard(board,black,6,2);
    }
    void addWhitePawnToBoard(Board board, Pawn pawn, int sizeOfAllPawns, int indexOfPawn) {
        board.addWhitePawn(pawn);
        assertThat(board.size()).isEqualTo(sizeOfAllPawns);
        assertThat(board.findWhitePawn(indexOfPawn)).isEqualTo(pawn);
    }
    void addBlackPawnToBoard(Board board, Pawn pawn, int sizeOfAllPawns, int indexOfPawn) {
        board.addBlackPawn(pawn);
        assertThat(board.size()).isEqualTo(sizeOfAllPawns);
        assertThat(board.findBlackPawn(indexOfPawn)).isEqualTo(pawn);
    }




    @Test
    @DisplayName("board initialize Test")
    void boardInitializeTest() {
        String initBoard =
                "........" + System.lineSeparator() +
                        "PPPPPPPP" + System.lineSeparator() +
                        "........" + System.lineSeparator() +
                        "........" + System.lineSeparator() +
                        "........" + System.lineSeparator() +
                        "........" + System.lineSeparator() +
                        "pppppppp" + System.lineSeparator() +
                        "........"+ System.lineSeparator() ;

        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
        assertThat(initBoard).isEqualTo(board.print());
    }

}
