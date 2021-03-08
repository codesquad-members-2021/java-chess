package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.ChessTestBase;
import kr.codesquad.freddie.chess.piece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class FilesTest extends ChessTestBase {
    private Files files;

    @BeforeEach
    void setUp() {
        files = new Files();
        for (int i = 0; i < Board.RANK_SIZE; i++) {
            files.add(new File());
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
            files.add(whitePieceFactory.createPawn());
            assertThat(files.pieceCount())
                    .isEqualTo(i);
        }
    }

    @Test
    void addOutOfRange() {
        for (int i = 0; i < MAX_SIZE; i++) {
            files.add(whitePieceFactory.createPawn());
        }

        assertThatThrownBy(() -> files.add(whitePieceFactory.createPawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("더 이상 추가할 수 없습니다. 현재 크기 : 64");
    }

    @Test
    @DisplayName("하나만 추가하여 탐색")
    void findPieceOne() {
        Piece white = whitePieceFactory.createPawn();
        files.add(white);
        assertAll(
                () -> assertThat(files.pieceCount()).isEqualTo(1),
                () -> assertThat(files.findPiece(Position.of("a8"))).isEqualTo(white)
        );
    }

    @Test
    @DisplayName("하나 이상 추가하여 탐색")
    void findPieceMoreThanOne() {
        Piece white = whitePieceFactory.createPawn();
        files.add(white);
        Piece black = blackPieceFactory.createPawn();
        files.add(black);

        assertAll(
                () -> assertThat(files.pieceCount()).isEqualTo(2),
                () -> assertThat(files.findPiece(Position.of("a8"))).isEqualTo(white),
                () -> assertThat(files.findPiece(Position.of("b8"))).isEqualTo(black)
        );
    }

    @Test
    void getPiecesBy() {
        files.fillWithRoyalAt(Color.BLACK);
        files.fillWithPawnAt(Color.BLACK);
        files.fillWithBlankAt(new RankIndex(3).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(4).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(5).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(6).getRankIndexForList());
        files.fillWithRoyalAt(Color.WHITE);
        files.fillWithPawnAt(Color.WHITE);

        assertThat(files.getPiecesBy(Color.BLACK)).isEqualTo(Arrays.asList(
                blackPieceFactory.createQueen(),
                blackPieceFactory.createRook(),
                blackPieceFactory.createRook(),
                blackPieceFactory.createBishop(),
                blackPieceFactory.createBishop(),
                blackPieceFactory.createKnight(),
                blackPieceFactory.createKnight(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createPawn(),
                blackPieceFactory.createKing()
        ));
        assertThat(files.getPiecesBy(Color.WHITE)).isEqualTo(Arrays.asList(
                whitePieceFactory.createQueen(),
                whitePieceFactory.createRook(),
                whitePieceFactory.createRook(),
                whitePieceFactory.createBishop(),
                whitePieceFactory.createBishop(),
                whitePieceFactory.createKnight(),
                whitePieceFactory.createKnight(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createPawn(),
                whitePieceFactory.createKing()
        ));
    }

    @Test
    void getNumberOf() {
        for (int i = 0; i < MAX_SIZE; i++) {
            files.add(PieceFactory.createBlank());
        }

        files.set(Position.of("b8"), blackPieceFactory.createKing());
        files.set(Position.of("c8"), blackPieceFactory.createRook());
        files.set(Position.of("a7"), blackPieceFactory.createPawn());
        files.set(Position.of("c7"), blackPieceFactory.createPawn());
        files.set(Position.of("d7"), blackPieceFactory.createBishop());
        files.set(Position.of("b6"), blackPieceFactory.createPawn());
        files.set(Position.of("e6"), blackPieceFactory.createQueen());
        files.set(Position.of("f4"), whitePieceFactory.createKnight());
        files.set(Position.of("g4"), whitePieceFactory.createQueen());
        files.set(Position.of("f3"), whitePieceFactory.createPawn());
        files.set(Position.of("g2"), whitePieceFactory.createPawn());
        files.set(Position.of("e1"), whitePieceFactory.createRook());
        files.set(Position.of("f1"), whitePieceFactory.createKing());

        assertAll(
                () -> assertThat(files.getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(1),
                () -> assertThat(files.getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(3),
                () -> assertThat(files.getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(1),
                () -> assertThat(files.getNumberOf(Color.BLACK, Kind.QUEEN)).isEqualTo(1),
                () -> assertThat(files.getNumberOf(Color.WHITE, Kind.KNIGHT)).isEqualTo(1),
                () -> assertThat(files.getNumberOf(Color.WHITE, Kind.QUEEN)).isEqualTo(1),
                () -> assertThat(files.getNumberOf(Color.WHITE, Kind.PAWN)).isEqualTo(2),
                () -> assertThat(files.getNumberOf(Color.WHITE, Kind.ROOK)).isEqualTo(1),
                () -> assertThat(files.getNumberOf(Color.WHITE, Kind.KING)).isEqualTo(1)
        );
    }

    @Test
    void groupingByCalculablePiece() {
        files.fillWithRoyalAt(Color.BLACK);
        files.fillWithPawnAt(Color.BLACK);
        files.fillWithBlankAt(new RankIndex(3).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(4).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(5).getRankIndexForList());
        files.fillWithBlankAt(new RankIndex(6).getRankIndexForList());
        files.fillWithRoyalAt(Color.WHITE);
        files.fillWithPawnAt(Color.WHITE);

        Map<CalculablePiece, Double> calculablePieceDoubleMap = files.groupingByCalculablePiece(Color.BLACK);

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
