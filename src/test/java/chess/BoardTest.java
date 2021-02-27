package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUP() {
        board = new Board();
    }

    @DisplayName("보드의 초기화와 출력이 올바르게 되는지 확인한다.")
    @Test
    void check() {
        board.initializeBoard();
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard())
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }

    @DisplayName("해당 위치의 기물이 올바르게 반환되는지 확인한다.")
    @Test
    void findPiece() {
        board.initializeBoard();
        Position position = new Position("a8");
        assertThat(board.findPiece(position))
                .isEqualTo(Piece.createBlackRook(position));
        position = new Position("h8");
        assertThat(board.findPiece(position))
                .isEqualTo(Piece.createBlackRook(position));
        position = new Position("a1");
        assertThat(board.findPiece(position))
                .isEqualTo(Piece.createWhiteRook(position));
        position = new Position("h1");
        assertThat(board.findPiece(new Position("h1")))
                .isEqualTo(Piece.createWhiteRook(position));
    }

    @DisplayName("기물이 설정한 위치가 올바르게 변경되는지 확인한다.")
    @Test
    void setPiece() {
        board.initializeEmpty();

        Position position = new Position("b5");
        Piece piece = Piece.createBlackRook(position);

        board.move(position, piece);
        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @DisplayName("기물의 색깔별로 점수가 올바르게 계산되는지 확인한다.")
    @Test
    void calculatePoint() {
        getBoardWithSeveralPiece();

        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(7.0);

        System.out.println(board.showBoard());
    }

    @DisplayName("남아있는 기물을 점수별로 정렬한 리스트를 올바르게 얻는지 확인한다.")
    @Test
    void sortPiece() {
        getBoardWithSeveralPiece();
        List<Type> whitePiece = board.sortPiece(Color.WHITE);
        List<Type> blackPiece = board.sortPiece(Color.BLACK);

        assertThat(whitePiece.toString()).isEqualTo("[ROOK, PAWN, PAWN, PAWN, KING]");
        assertThat(blackPiece.toString()).isEqualTo("[QUEEN, ROOK, PAWN, KING]");
    }

    void getBoardWithSeveralPiece() {
        board.initializeEmpty();

        Position position = new Position("b6");
        addPiece(position, Piece.createBlackPawn(position));
        position = new Position("e6");
        addPiece(position, Piece.createBlackQueen(position));
        position = new Position("b8");
        addPiece(position, Piece.createBlackKing(position));
        position = new Position("c8");
        addPiece(position, Piece.createBlackRook(position));

        position = new Position("f2");
        addPiece(position, Piece.createWhitePawn(position));
        position = new Position("g2");
        addPiece(position, Piece.createWhitePawn(position));
        position = new Position("e1");
        addPiece(position, Piece.createWhiteRook(position));
        position = new Position("f1");
        addPiece(position, Piece.createWhiteKing(position));
        position = new Position("f3");
        addPiece(position, Piece.createWhitePawn(position));
    }

    void addPiece(Position position, Piece piece) {
        board.move(position, piece);
    }
}
