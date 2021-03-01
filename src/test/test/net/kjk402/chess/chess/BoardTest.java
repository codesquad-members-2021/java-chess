package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class BoardTest {
    private Board board;
    private Position position;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판에서 색상과 종류가 같은 기물의 개수를 반환한다.")
    void countSamePieces() {
        board.initialize();
        assertAll(
                () -> assertThat(board.countSamePiece(Piece.Color.BLACK, Piece.Type.PAWN)).isEqualTo(8),
                () -> assertThat(board.countSamePiece(Piece.Color.WHITE, Piece.Type.KNIGHT)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("특정 위치로 기물을 요청 시에 알맞은 기물이 조회되는 지 확인한다.")
    void findPiece() {
        board.initialize();

        assertAll(
                () -> verifyPiecePosition("h8", Piece.Color.BLACK, Piece.Type.ROOK),
                () -> verifyPiecePosition("g8", Piece.Color.BLACK, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("c8", Piece.Color.BLACK, Piece.Type.BISHOP),
                () -> verifyPiecePosition("d8", Piece.Color.BLACK, Piece.Type.QUEEN),
                () -> verifyPiecePosition("e8", Piece.Color.BLACK, Piece.Type.KING),
                () -> verifyPiecePosition("f8", Piece.Color.BLACK, Piece.Type.BISHOP),
                () -> verifyPiecePosition("g8", Piece.Color.BLACK, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("h8", Piece.Color.BLACK, Piece.Type.ROOK),

                () -> verifyPiecePosition("a1", Piece.Color.WHITE, Piece.Type.ROOK),
                () -> verifyPiecePosition("b1", Piece.Color.WHITE, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("c1", Piece.Color.WHITE, Piece.Type.BISHOP),
                () -> verifyPiecePosition("d1", Piece.Color.WHITE, Piece.Type.QUEEN),
                () -> verifyPiecePosition("e1", Piece.Color.WHITE, Piece.Type.KING),
                () -> verifyPiecePosition("f1", Piece.Color.WHITE, Piece.Type.BISHOP),
                () -> verifyPiecePosition("g1", Piece.Color.WHITE, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("h1", Piece.Color.WHITE, Piece.Type.ROOK)
        );
    }

    void verifyPiecePosition(String index, Piece.Color color, Piece.Type type) {
        assertAll(
                () -> assertThat(board.findPiece(index).getColor()).isEqualTo(color),
                () -> assertThat(board.findPiece(index).getType()).isEqualTo(type)
        );
    }

    @Test
    @DisplayName("임의의 기물을 체스판 위 특정 위치에 배치")
    void move() {
        board.initializeEmpty();

        Piece blackRook = Piece.createBlackRook(new Position("b5"));
        board.movePiece("b5", blackRook);
        Piece blackKing = Piece.createBlackKing(new Position("b6"));
        board.movePiece("b6", blackKing);
        Piece whiteKing = Piece.createWhiteKing(new Position("e3"));
        board.movePiece("e3", whiteKing);

        assertAll(
                () -> assertThat(blackRook).isEqualTo(board.findPiece("b5")),
                () -> assertThat(blackKing).isEqualTo(board.findPiece("b6")),
                () -> assertThat(whiteKing).isEqualTo(board.findPiece("e3"))
        );
    }

    @Test
    @DisplayName("같은 색상을 가진 기물들의 점수를 합산하여 값이 맞는 지 확인한다.")
    void calculatePoint() {
        board.initializeEmpty();

        board.movePiece("b6", Piece.createBlackPawn(position));
        board.movePiece("e6", Piece.createBlackQueen(position));
        board.movePiece("b8", Piece.createBlackKing(position));
        board.movePiece("c8", Piece.createBlackRook(position));

        board.movePiece("f2", Piece.createWhitePawn(position));
        board.movePiece("g2", Piece.createWhitePawn(position));
        board.movePiece("e1", Piece.createWhiteRook(position));
        board.movePiece("f1", Piece.createWhiteKing(position));

        assertAll(
                () -> assertThat(15.0).isEqualTo(board.calculatePoint(Piece.Color.BLACK)),
                () -> assertThat(7.0).isEqualTo(board.calculatePoint(Piece.Color.WHITE))
        );
    }

    @Test
    @DisplayName("기물의 색상 별로 점수가 높은 순으로 정렬한다.")
    void piecesSortByPoint() {
        List<Piece> pieces = new ArrayList<>();
        setPiece(pieces);
        assertAll(
                () -> assertThat(board.piecesSort(pieces, Piece.Color.BLACK)).isEqualTo("QRBP"),
                () -> assertThat(board.piecesSort(pieces, Piece.Color.WHITE)).isEqualTo("rrbppk")
        );
    }

    void setPiece(List<Piece> list) {
        list.add(Piece.createBlackPawn(position));
        list.add(Piece.createBlackRook(position));
        list.add(Piece.createBlackBishop(position));
        list.add(Piece.createBlackQueen(position));

        list.add(Piece.createWhiteRook(position));
        list.add(Piece.createWhitePawn(position));
        list.add(Piece.createWhiteBishop(position));
        list.add(Piece.createWhitePawn(position));
        list.add(Piece.createWhiteKing(position));
        list.add(Piece.createWhiteRook(position));
    }

}
