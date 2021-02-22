package net.jung.chess;

import net.jung.chess.pieces.Color;
import net.jung.chess.pieces.Type;
import net.jung.chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.jung.chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {

    private Board board;
    private Piece whitePawn;
    private Piece blackPawn;

    @BeforeEach
    void setUp() {
        board = new Board();
        whitePawn = Piece.createPiece(Color.WHITE, Type.PAWN);
        blackPawn = Piece.createPiece(Color.BLACK, Type.PAWN);

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
    @DisplayName("addWhitePawn(Piece pawn)의 매개변수로 blackPawn을 넘기면 whitePawnList에 더해지지 않고 반대도 마찬가지이다.")
    void addBlackPawnToWhitePawnList() {
        board.addWhitePiece(blackPawn);
        board.addBlackPiece(whitePawn);
        assertAll(
                () -> assertThat(board.whitePieceListSize()).isEqualTo(0),
                () -> assertThat(board.blackPieceListSize()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("initialize()는 32개 모든 말을 체스판 위에 올린다.")
    void InitializeAddsEveryPiece(){
        board.initialize();
        String blankRank = appendNewLine("********");
        assertAll(
                () -> assertThat(board.size()).isEqualTo(32),
                () -> assertThat(board.print()).isEqualTo(
                    appendNewLine("RNBQKBNR")
                    +appendNewLine("PPPPPPPP")
                    +blankRank+blankRank+blankRank+blankRank
                    +appendNewLine("pppppppp")
                    +appendNewLine("rnbqkbnr"))
        );
    }
}
