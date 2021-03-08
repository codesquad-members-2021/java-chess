package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.*;
import kr.codesquad.freddie.chess.ChessTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest extends ChessTestBase {
    private Board board;

    @BeforeEach
    void setBoard() {
        board = new Board();
    }

    @Test
    void initializePieceByBlack() {
        board.initializePieceBy(Color.BLACK);

        checkInitializeRoyal(Color.BLACK);
        checkInitializePawn(Color.BLACK);
    }

    @Test
    void initializePieceByWhite() {
        board.initializePieceBy(Color.WHITE);

        checkInitializeRoyal(Color.WHITE);
        checkInitializePawn(Color.WHITE);
    }

    private void checkInitializeRoyal(Color color) {
        int rank = color == Color.BLACK ? 8 : 1;
        PieceFactory pieceFactory = new PieceFactory(color);

        assertThat(board.findPiece("a" + rank)).isEqualTo(pieceFactory.createRook());
        assertThat(board.findPiece("b" + rank)).isEqualTo(pieceFactory.createKnight());
        assertThat(board.findPiece("c" + rank)).isEqualTo(pieceFactory.createBishop());
        assertThat(board.findPiece("d" + rank)).isEqualTo(pieceFactory.createQueen());
        assertThat(board.findPiece("e" + rank)).isEqualTo(pieceFactory.createKing());
        assertThat(board.findPiece("f" + rank)).isEqualTo(pieceFactory.createBishop());
        assertThat(board.findPiece("g" + rank)).isEqualTo(pieceFactory.createKnight());
        assertThat(board.findPiece("h" + rank)).isEqualTo(pieceFactory.createRook());
    }

    private void checkInitializePawn(Color color) {
        int rank = color == Color.BLACK ? 7 : 2;
        Piece pawn = Pawn.create(color);

        assertThat(board.findPiece("a" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("b" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("c" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("d" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("e" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("f" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("g" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("h" + rank)).isEqualTo(pawn);
    }

    @Test
    void initializeEmptyPiece() {
        board.initializeEmptyPiece();

        StringBuilder sb = new StringBuilder();
        for (int i = 3; i <= 6; i++) {
            sb.delete(0, sb.length());
            for (char j = 'a'; j <= 'h'; j++) {
                assertThat(board.findPiece(sb.append(j).append(i).toString()))
                        .isEqualTo(PieceFactory.createBlank());
            }
        }
    }

    @Test
    @DisplayName("1개 부터 64개까지 넣으면서 사이즈 일치하는지 확인")
    void add() {
        for (int i = 0; i <= MAX_SIZE; i++) {
            Board board = new Board();

            for (int j = 0; j < i; j++) {
                board.add(whitePieceFactory.createPawn());
            }
            assertThat(board.pieceCount())
                    .isEqualTo(i);

            System.out.println(board);
        }
    }

    @Test
    @DisplayName("8개가 넘어가면 다음 줄로 넘어가기 때문에 에러가 발생하면 안된다.")
    void addFillRank() {
        int size = File.SIZE + 1;
        for (int i = 1; i <= size; i++) {
            board.add(whitePieceFactory.createPawn());
            assertThat(board.pieceCount())
                    .isEqualTo(i);
        }
    }

    @Test
    void addOutOfRange() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(whitePieceFactory.createPawn());
        }

        assertThatThrownBy(() -> board.add(whitePieceFactory.createPawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("더 이상 추가할 수 없습니다. 현재 크기 : 64");
    }

    @Test
    @DisplayName("하나만 추가하여 탐색")
    void findPieceOne() {
        Piece white = whitePieceFactory.createPawn();
        board.add(white);
        assertAll(
                () -> assertThat(board.pieceCount()).isEqualTo(1),
                () -> assertThat(board.findPiece("a8")).isEqualTo(white)
        );
    }

    @Test
    @DisplayName("하나 이상 추가하여 탐색")
    void findPieceMoreThanOne() {
        Piece white = whitePieceFactory.createPawn();
        board.add(white);
        Piece black = blackPieceFactory.createPawn();
        board.add(black);

        assertAll(
                () -> assertThat(board.pieceCount()).isEqualTo(2),
                () -> assertThat(board.findPiece("a8")).isEqualTo(white),
                () -> assertThat(board.findPiece("b8")).isEqualTo(black)
        );
    }

    @Test
    void groupingByCalculablePiece() {
        initBoard(board);

        Map<CalculablePiece, Double> calculablePieceDoubleMap = board.groupingByCalculablePiece(Color.BLACK);

        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'a'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'b'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'c'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'd'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'e'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'f'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'g'))).isEqualTo(Kind.PAWN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createPawn(), 'h'))).isEqualTo(Kind.PAWN.point());

        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createRook(), 'a'))).isEqualTo(Kind.ROOK.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createKnight(), 'b'))).isEqualTo(Kind.KNIGHT.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createBishop(), 'c'))).isEqualTo(Kind.BISHOP.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createQueen(), 'd'))).isEqualTo(Kind.QUEEN.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createKing(), 'e'))).isEqualTo(Kind.KING.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createBishop(), 'f'))).isEqualTo(Kind.BISHOP.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createKnight(), 'g'))).isEqualTo(Kind.KNIGHT.point());
        assertThat(calculablePieceDoubleMap.get(CalculablePiece.create(blackPieceFactory.createRook(), 'h'))).isEqualTo(Kind.ROOK.point());
    }
}
