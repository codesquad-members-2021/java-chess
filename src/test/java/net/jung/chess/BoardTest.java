package net.jung.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.jung.chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.initialize();
    }


    @Test
    @DisplayName("initialize()는 32개 모든 말을 체스판 위에 올린다.")
    void initializeAddsEveryPiece() {
        int maxNumOfPieces = 32;
        String BLANK_RANK = appendNewLine("********");

        assertAll(
                () -> assertThat(board.boardPieceSize()).isEqualTo(maxNumOfPieces),
                () -> assertThat(board.boardLayoutToString()).isEqualTo(
                    appendNewLine("RNBQKBNR")
                    +appendNewLine("PPPPPPPP")
                    +BLANK_RANK
                    +BLANK_RANK
                    +BLANK_RANK
                    +BLANK_RANK
                    +appendNewLine("pppppppp")
                    +appendNewLine("rnbqkbnr"))
        );
    }

    @Test
    @DisplayName("certainPieceSize는 보드 위의 특정 색/타입의 피스 개수를 리턴한다")
    void checkCertainPieceSize () {
        int pawnSize = 8;
        int nonRoyalSize = 2;
        int royalSize = 1;
        assertAll (
                () -> assertThat(board.certainPieceSize(Piece.Color.WHITE, Piece.Type.PAWN)).isEqualTo(pawnSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.BLACK, Piece.Type.PAWN)).isEqualTo(pawnSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.WHITE, Piece.Type.ROOK)).isEqualTo(nonRoyalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.BLACK, Piece.Type.ROOK)).isEqualTo(nonRoyalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.WHITE, Piece.Type.KNIGHT)).isEqualTo(nonRoyalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.BLACK, Piece.Type.KNIGHT)).isEqualTo(nonRoyalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.WHITE, Piece.Type.BISHOP)).isEqualTo(nonRoyalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.BLACK, Piece.Type.BISHOP)).isEqualTo(nonRoyalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.WHITE, Piece.Type.QUEEN)).isEqualTo(royalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.BLACK, Piece.Type.QUEEN)).isEqualTo(royalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.WHITE, Piece.Type.KING)).isEqualTo(royalSize),
                () -> assertThat(board.certainPieceSize(Piece.Color.BLACK, Piece.Type.KING)).isEqualTo(royalSize)

        );
    }
}
