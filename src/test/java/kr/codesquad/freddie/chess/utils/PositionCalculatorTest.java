package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.ChessTestBase;
import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionCalculatorTest extends ChessTestBase {
    private PositionCalculator positionCalculator;
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        initBoard(board);
    }

    @Test
    void getFileDistance() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b2"));

        assertThat(positionCalculator.getFileDistance()).isEqualTo(-1);
    }

    @Test
    void getFileDistanceZero() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("a2"));

        assertThat(positionCalculator.getFileDistance()).isEqualTo(0);
    }

    @Test
    void getRankDistance() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b2"));

        assertThat(positionCalculator.getRankDistance()).isEqualTo(-1);
    }

    @Test
    void getRankDistanceZero() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b1"));

        assertThat(positionCalculator.getRankDistance()).isEqualTo(0);
    }

    @Test
    void getSourcePieceFrom() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b1"));

        assertThat(positionCalculator.getSourcePieceFrom(board)).isEqualTo(whitePieceFactory.createRook());
    }

    @Test
    void getTargetPieceFrom() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b1"));

        assertThat(positionCalculator.getTargetPieceFrom(board)).isEqualTo(whitePieceFactory.createKnight());
    }

    @Test
    void getGradientHorizontal() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b1"));

        assertThat(positionCalculator.getGradient()).isCloseTo(0, Offset.offset(0.1));
    }

    @Test
    void getGradientVertical() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("a2"));

        assertThat(positionCalculator.getGradient()).isCloseTo(0, Offset.offset(0.1));
    }

    @Test
    void getGradient() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b2"));

        assertThat(positionCalculator.getGradient()).isCloseTo(1, Offset.offset(0.1));
    }

    @Test
    void isDiagonal() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b2"));

        assertThat(positionCalculator.isDiagonal()).isTrue();
    }

    @Test
    void isDiagonalHorizontal() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("b1"));

        assertThat(positionCalculator.isDiagonal()).isFalse();
    }

    @Test
    void isDiagonalVertical() {
        positionCalculator = new PositionCalculator(Position.of("a1"), Position.of("a2"));

        assertThat(positionCalculator.isDiagonal()).isFalse();
    }
}
