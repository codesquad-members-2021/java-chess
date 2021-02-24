package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;
import net.sky.pieces.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;
    private PieceMaker whitePieceMaker;
    private PieceMaker blackPieceMaker;

    @BeforeEach
    void setup() {
        board = new Board();
        whitePieceMaker = new PieceMaker(Color.WHITE);
        blackPieceMaker = new PieceMaker(Color.BLACK);
    }

    @Test
    @DisplayName("체스판 초기화 확인")
    void create() {
        board.initialize();
        String blankRank = "........ ";

        assertThat(board.showBoard()).isEqualTo(appendNewLine("RNBQKBNR 8")
            + appendNewLine("PPPPPPPP 7")
            + blankRank + appendNewLine("6")
            + blankRank + appendNewLine("5")
            + blankRank + appendNewLine("4")
            + blankRank + appendNewLine("3")
            + appendNewLine("pppppppp 2")
            + appendNewLine("rnbqkbnr 1")
            + appendNewLine("")
            + appendNewLine("abcdefgh"));
    }

    @Test
    @DisplayName("기물의 개수 반환 테스트")
    void pieceCount() {
        board.initialize();

        Piece whitePawn = whitePieceMaker.createPawn();
        Piece whiteRook = whitePieceMaker.createRook();
        Piece whiteKnight = whitePieceMaker.createKnight();
        Piece whiteBishop = whitePieceMaker.createBishop();
        Piece whiteQueen = whitePieceMaker.createQueen();
        Piece whiteKing = whitePieceMaker.createKing();

        assertAll(
            () -> assertThat(board.pieceCount(whitePawn)).isEqualTo(8),
            () -> assertThat(board.pieceCount(whiteRook)).isEqualTo(2),
            () -> assertThat(board.pieceCount(whiteKnight)).isEqualTo(2),
            () -> assertThat(board.pieceCount(whiteBishop)).isEqualTo(2),
            () -> assertThat(board.pieceCount(whiteQueen)).isEqualTo(1),
            () -> assertThat(board.pieceCount(whiteKing)).isEqualTo(1)
        );

        Piece blackPawn = blackPieceMaker.createPawn();
        Piece blackRook = blackPieceMaker.createRook();
        Piece blackKnight = blackPieceMaker.createKnight();
        Piece blackBishop = blackPieceMaker.createBishop();
        Piece blackQueen = blackPieceMaker.createQueen();
        Piece blackKing = blackPieceMaker.createKing();

        assertAll(
            () -> assertThat(board.pieceCount(blackPawn)).isEqualTo(8),
            () -> assertThat(board.pieceCount(blackRook)).isEqualTo(2),
            () -> assertThat(board.pieceCount(blackKnight)).isEqualTo(2),
            () -> assertThat(board.pieceCount(blackBishop)).isEqualTo(2),
            () -> assertThat(board.pieceCount(blackQueen)).isEqualTo(1),
            () -> assertThat(board.pieceCount(blackKing)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("주어진 기물의 위치 확인")
    void findPiece() {
        board.initialize();

        assertAll(
            () -> assertThat(board.findPiece(new Position("a8")))
                .isEqualTo(blackPieceMaker.createRook()),
            () -> assertThat(board.findPiece(new Position("h8")))
                .isEqualTo(blackPieceMaker.createRook()),
            () -> assertThat(board.findPiece(new Position("a1")))
                .isEqualTo(whitePieceMaker.createRook()),
            () -> assertThat(board.findPiece(new Position("h1")))
                .isEqualTo(whitePieceMaker.createRook())
        );
    }

    @Test
    @DisplayName("기물의 위치 이동 확인")
    void movePiece() {
        board.initializeEmpty();

        Position position1 = new Position("b5");
        Piece blackRook = blackPieceMaker.createRook();
        board.move(position1, blackRook);

        Position position2 = new Position("b6");
        Piece blackKing = blackPieceMaker.createKing();
        board.move(position2, blackKing);

        Position position3 = new Position("e3");
        Piece whiteKing = whitePieceMaker.createKing();
        board.move(position3, whiteKing);

        assertAll(
            () -> assertThat(board.findPiece(position1)).isEqualTo(blackRook),
            () -> assertThat(board.findPiece(position2)).isEqualTo(blackKing),
            () -> assertThat(board.findPiece(position3)).isEqualTo(whiteKing)
        );

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("체스게임 점수 계산 확인")
    void calculatePoint() {
        board.initializeEmpty();

        addPiece(new Position("b6"), blackPieceMaker.createPawn());
        addPiece(new Position("e6"), blackPieceMaker.createQueen());
        addPiece(new Position("b8"), blackPieceMaker.createKing());
        addPiece(new Position("c8"), blackPieceMaker.createRook());
        addPiece(new Position("f7"), blackPieceMaker.createPawn());

        addPiece(new Position("f2"), whitePieceMaker.createPawn());
        addPiece(new Position("f3"), whitePieceMaker.createPawn());
        addPiece(new Position("e1"), whitePieceMaker.createRook());
        addPiece(new Position("f1"), whitePieceMaker.createKing());

        board.print();

        assertAll(
            () -> assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(16.0),
            () -> assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(6.0)
        );
    }

    private void addPiece(Position position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    @DisplayName("색깔별 기물의 점수가 높은 순으로 정렬되는지 확인")
    void sortByScore() {
        board.initialize();

        board.move(new Position("a3"), whitePieceMaker.createPawn());
        board.move(new Position("a6"), blackPieceMaker.createPawn());
        board.print();

        assertAll(
            () -> assertThat(board.sortByScore(Color.BLACK)).isEqualTo("QRRBBNNPPPPPPPPPK"),
            () -> assertThat(board.sortByScore(Color.WHITE)).isEqualTo("qrrbbnnpppppppppk")
        );
    }


}
