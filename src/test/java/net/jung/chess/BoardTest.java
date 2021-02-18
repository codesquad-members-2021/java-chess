package net.jung.chess;

import net.jung.chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {

    private Board board;
    private Piece whitePawn;
    private Piece blackPawn;

    @BeforeEach
    void setUp() {
        board = new Board();
        whitePawn = Piece.createPiece(Color.WHITE, Name.PAWN);
        blackPawn = Piece.createPiece(Color.BLACK, Name.PAWN);

    }

    @Test
    @DisplayName("보드를 생성하고 흰색 검은색 폰을 추가한 후 size, findPawn 메서드 검증한다.")
    void createBoardAddPawns() throws Exception {

        assertAll(
                () -> {
                    board.addWhitePiece(whitePawn);
                    assertAll("흰색 폰을 보드에 올린 후 size, findPawn메서드 검증한다.",
                            () -> assertThat(board.size()).isEqualTo(1),
                            () -> assertThat(board.findWhitePiece(0)).isEqualTo(whitePawn));
                },
                () -> {
                    board.addBlackPiece(blackPawn);
                    assertAll("검은색 폰을 보드에 올린 후 size, findPawn메서드 검증한다.",
                            () -> assertThat(board.size()).isEqualTo(2),
                            () -> assertThat(board.findBlackPiece(0)).isEqualTo(blackPawn));
                }
        );

    }

    @Test
    @DisplayName("initialize()는 Board에 흑백 폰을 8개씩 더한 후 getPawnsResult는 대표알파벳을 합쳐 리턴한다.")
    void initializeToAddPawnsToBoard() {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("print()는 initialize된 보드를 출력한다.")
    void checkPrint() {
        board.initialize();
        System.out.print(board.print());

        StringBuilder sb = new StringBuilder();
        sb.append("********").append(System.getProperty("line.separator"))
                .append("PPPPPPPP").append(System.getProperty("line.separator"))
                .append("********").append(System.getProperty("line.separator"))
                .append("********").append(System.getProperty("line.separator"))
                .append("********").append(System.getProperty("line.separator"))
                .append("********").append(System.getProperty("line.separator"))
                .append("pppppppp").append(System.getProperty("line.separator"))
                .append("********");
        String expectedLayout = sb.toString();

        assertThat(board.print()).isEqualTo(expectedLayout);
    }

    @Test
    @DisplayName("addWhitePawn(Piece pawn)의 매개변수로 blackPawn을 넘기면 whitePawnList에 더해지지 않고 반대도 마찬가지이다.")
    void addBlackPawnToWhitePawnList() {
        board.addWhitePiece(blackPawn);
        board.addBlackPiece(whitePawn);
        assertAll(
                () -> assertThat(board.whitePieceListSize()).isEqualTo(0),
                () -> assertThat(board.blackPieceListSize()).isEqualTo(0)
        );

    }
}
