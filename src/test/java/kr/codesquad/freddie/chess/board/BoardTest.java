package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest extends BoardTestBase {
    private Board board;
    private static final int MAX_SIZE = Board.RANK_SIZE * File.SIZE;

    @BeforeEach
    void setBoard() {
        board = new Board();
    }

    @Test
    void initialize() {
        board.initialize();
        checkInitializeRoyal(Color.BLACK);
        checkInitializeRoyal(Color.WHITE);
        checkInitializePawn(Color.BLACK);
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
        Piece pawn = new Piece(color, Kind.PAWN);

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
    @DisplayName("1개 부터 64개까지 넣으면서 사이즈 일치하는지 확인")
    void add() {
        for (int i = 0; i <= MAX_SIZE; i++) {
            Board board = new Board();

            for (int j = 0; j < i; j++) {
                board.add(new Piece(Color.WHITE, Kind.PAWN));
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
            board.add(new Piece(Color.WHITE, Kind.PAWN));
            assertThat(board.pieceCount())
                    .isEqualTo(i);
        }
    }

    @Test
    void addOutOfRange() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(new Piece(Color.WHITE, Kind.PAWN));
        }

        assertThatThrownBy(() -> board.add(new Piece(Color.WHITE, Kind.PAWN)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("더 이상 추가할 수 없습니다. 현재 크기 : 64");
    }

    @Test
    @DisplayName("하나만 추가하여 탐색")
    void findPieceOne() {
        Piece white = new Piece(Color.WHITE, Kind.PAWN);
        board.add(white);
        assertAll(
                () -> assertThat(board.pieceCount()).isEqualTo(1),
                () -> assertThat(board.findPiece("a8")).isEqualTo(white)
        );
    }

    @Test
    @DisplayName("하나 이상 추가하여 탐색")
    void findPieceMoreThanOne() {
        Piece white = new Piece(Color.WHITE, Kind.PAWN);
        board.add(white);
        Piece black = new Piece(Color.BLACK, Kind.PAWN);
        board.add(black);

        assertAll(
                () -> assertThat(board.pieceCount()).isEqualTo(2),
                () -> assertThat(board.findPiece("a8")).isEqualTo(white),
                () -> assertThat(board.findPiece("b8")).isEqualTo(black)
        );
    }

    @Test
    void getPiecesBy() {
        board.initialize();
        assertThat(board.getPiecesBy(Color.BLACK)).isEqualTo(Arrays.asList(
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
        assertThat(board.getPiecesBy(Color.WHITE)).isEqualTo(Arrays.asList(
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
    void moveKing() {
        initBoardWithBlank();
        checkMoveKing("b3", "b4");
        checkMoveKing("b3", "b2");
        checkMoveKing("b3", "c3");
        checkMoveKing("b3", "a3");
        checkMoveKing("b3", "c4");
        checkMoveKing("b3", "a4");
        checkMoveKing("b3", "c2");
        checkMoveKing("b3", "a2");
    }

    private void checkMoveKing(String source, String target) {
        board.set(source, blackPieceFactory.createKing());
        board.set(target, whitePieceFactory.createPawn());
        board.move(source, target);

        assertThat(board.findPiece(source)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(target)).isEqualTo(blackPieceFactory.createKing());
    }


    @Test
    void moveKingToWrongTarget() {
        initBoardWithBlank();
        checkMoveKingToWrongTarget("b3", "b5");
        checkMoveKingToWrongTarget("b3", "b1");
        checkMoveKingToWrongTarget("b3", "d3");
        checkMoveKingToWrongTarget("c3", "a3");
    }

    private void checkMoveKingToWrongTarget(String source, String target) {
        board.set(source, blackPieceFactory.createKing());
        assertThatThrownBy(()->board.move(source, target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveKnight() {
        initBoardWithBlank();
        checkMoveKnight("d4", "c6");
        checkMoveKnight("d4", "b5");
        checkMoveKnight("d4", "b3");
        checkMoveKnight("d4", "c2");
        checkMoveKnight("d4", "e2");
        checkMoveKnight("d4", "f3");
        checkMoveKnight("d4", "f5");
        checkMoveKnight("d4", "e6");
    }

    private void checkMoveKnight(String source, String target) {
        board.set(source, blackPieceFactory.createKnight());
        board.set(target, whitePieceFactory.createPawn());
        board.move(source, target);

        assertThat(board.findPiece(source)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(target)).isEqualTo(blackPieceFactory.createKnight());
    }

    @Test
    void moveKnightToWrongTarget() {
        initBoardWithBlank();
        checkMoveKnightToWrongTarget("d4", "a4");
        checkMoveKnightToWrongTarget("d4", "b4");
        checkMoveKnightToWrongTarget("d4", "c4");
        checkMoveKnightToWrongTarget("d4", "e4");
        checkMoveKnightToWrongTarget("d4", "f4");
        checkMoveKnightToWrongTarget("d4", "g4");
        checkMoveKnightToWrongTarget("d4", "h4");
        checkMoveKnightToWrongTarget("d4", "d1");
        checkMoveKnightToWrongTarget("d4", "d2");
        checkMoveKnightToWrongTarget("d4", "d3");
        checkMoveKnightToWrongTarget("d4", "d5");
        checkMoveKnightToWrongTarget("d4", "d6");
        checkMoveKnightToWrongTarget("d4", "d7");
        checkMoveKnightToWrongTarget("d4", "c7");
        checkMoveKnightToWrongTarget("d4", "a5");
        checkMoveKnightToWrongTarget("d4", "a3");
        checkMoveKnightToWrongTarget("d4", "c1");
        checkMoveKnightToWrongTarget("d4", "e1");
        checkMoveKnightToWrongTarget("d4", "g3");
        checkMoveKnightToWrongTarget("d4", "g5");
        checkMoveKnightToWrongTarget("d4", "e7");
        checkMoveKnightToWrongTarget("d4", "b6");
        checkMoveKnightToWrongTarget("d4", "b2");
        checkMoveKnightToWrongTarget("d4", "f2");
        checkMoveKnightToWrongTarget("d4", "f6");

    }

    private void checkMoveKnightToWrongTarget(String source, String target) {
        board.set(source, blackPieceFactory.createKnight());
        assertThatThrownBy(()->board.move(source, target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveBishop() {
        initBoardWithBlank();
        checkMoveBishop("d4", "e5");
        checkMoveBishop("d4", "f6");
        checkMoveBishop("d4", "e3");
        checkMoveBishop("d4", "f2");
        checkMoveBishop("d4", "c5");
        checkMoveBishop("d4", "b6");
        checkMoveBishop("d4", "c3");
        checkMoveBishop("d4", "b2");
    }

    private void checkMoveBishop(String source, String target) {
        board.set(source, blackPieceFactory.createBishop());
        board.set(target, whitePieceFactory.createPawn());
        board.move(source, target);

        assertThat(board.findPiece(source)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(target)).isEqualTo(blackPieceFactory.createBishop());
    }

    @Test
    void moveBishopToWrongTarget() {
        initBoardWithBlank();
        checkMoveBishopToWrongTarget("d4", "d5");
        checkMoveBishopToWrongTarget("d4", "d6");
        checkMoveBishopToWrongTarget("d4", "d3");
        checkMoveBishopToWrongTarget("d4", "d2");
        checkMoveBishopToWrongTarget("d4", "c4");
        checkMoveBishopToWrongTarget("d4", "b4");
        checkMoveBishopToWrongTarget("d4", "e4");
        checkMoveBishopToWrongTarget("d4", "f4");
        checkMoveBishopToWrongTarget("d4", "c6");
        checkMoveBishopToWrongTarget("d4", "b5");
        checkMoveBishopToWrongTarget("d4", "b3");
        checkMoveBishopToWrongTarget("d4", "c2");
        checkMoveBishopToWrongTarget("d4", "e2");
        checkMoveBishopToWrongTarget("d4", "f3");
        checkMoveBishopToWrongTarget("d4", "f5");
        checkMoveBishopToWrongTarget("d4", "e6");
    }

    private void checkMoveBishopToWrongTarget(String source, String target) {
        board.set(source, blackPieceFactory.createBishop());
        assertThatThrownBy(()->board.move(source, target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveToSameColor() {
        initBoardWithBlank();
        board.set("b3", blackPieceFactory.createKing());
        board.set("b4", blackPieceFactory.createPawn());

        assertThatThrownBy(() -> board.move("b3", "b4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 위치의 기물이 같은 색상입니다. source : Piece{color=BLACK, kind=KING}, target : Piece{color=BLACK, kind=PAWN}");
        assertThatThrownBy(() -> board.move("b3", "b3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 위치의 기물이 같은 색상입니다. source : Piece{color=BLACK, kind=KING}, target : Piece{color=BLACK, kind=KING}");
    }

    @Test
    void getRepresentationInitBoard() {
        String representation = board.initialize().getRepresentation();

        String expected = new StringBuilder()
                .append("RNBQKBNR").append(System.lineSeparator())
                .append("PPPPPPPP").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("pppppppp").append(System.lineSeparator())
                .append("rnbqkbnr")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }

    @Test
    void getRepresentationNotInitBoard() {
        String representation = board.getRepresentation();

        String expected = new StringBuilder()
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("set으로 넣은 뒤 getRepresentation과 getNumberOf로 확인")
    void verifySetWithGetRepresentationAndGetNumberOf() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(Piece.createBlank());
        }

        board.set("b8", blackPieceFactory.createKing());
        board.set("c8", blackPieceFactory.createRook());
        board.set("a7", blackPieceFactory.createPawn());
        board.set("c7", blackPieceFactory.createPawn());
        board.set("d7", blackPieceFactory.createBishop());
        board.set("b6", blackPieceFactory.createPawn());
        board.set("e6", blackPieceFactory.createQueen());
        board.set("f4", whitePieceFactory.createKnight());
        board.set("g4", whitePieceFactory.createQueen());
        board.set("f3", whitePieceFactory.createPawn());
        board.set("g2", whitePieceFactory.createPawn());
        board.set("e1", whitePieceFactory.createRook());
        board.set("f1", whitePieceFactory.createKing());

        String expected = new StringBuilder()
                .append(".KR.....").append(System.lineSeparator())
                .append("P.PB....").append(System.lineSeparator())
                .append(".P..Q...").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append(".....nq.").append(System.lineSeparator())
                .append(".....p..").append(System.lineSeparator())
                .append("......p.").append(System.lineSeparator())
                .append("....rk..")
                .toString();
        assertAll(
                () -> assertThat(board.getRepresentation()).isEqualTo(expected),
                () -> assertThat(board.getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(1),
                () -> assertThat(board.getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(3),
                () -> assertThat(board.getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(1),
                () -> assertThat(board.getNumberOf(Color.BLACK, Kind.QUEEN)).isEqualTo(1),
                () -> assertThat(board.getNumberOf(Color.WHITE, Kind.KNIGHT)).isEqualTo(1),
                () -> assertThat(board.getNumberOf(Color.WHITE, Kind.QUEEN)).isEqualTo(1),
                () -> assertThat(board.getNumberOf(Color.WHITE, Kind.PAWN)).isEqualTo(2),
                () -> assertThat(board.getNumberOf(Color.WHITE, Kind.ROOK)).isEqualTo(1),
                () -> assertThat(board.getNumberOf(Color.WHITE, Kind.KING)).isEqualTo(1)
        );
    }

    @Test
    void groupingByCalculablePiece() {
        board.initialize();


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

    private void initBoardWithBlank() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(Piece.createBlank());
        }
    }
}
