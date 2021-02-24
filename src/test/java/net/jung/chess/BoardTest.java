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

    @Test
    @DisplayName("8번 rank를 호출하면 rankList의 0번째 rank가 리턴되고, 6번 rank호출하면 2번쨰 rank가 호출된다.")
    void checkGetRank() {
        assertAll(
                () -> assertThat(board.getRank(8).getRankRepresentation()).isEqualTo("RNBQKBNR"),
                () -> assertThat(board.getRank(7).getRankRepresentation()).isEqualTo("PPPPPPPP"),
                () -> assertThat(board.getRank(6).getRankRepresentation()).isEqualTo("********"),
                () -> assertThat(board.getRank(2).getRankRepresentation()).isEqualTo("pppppppp"),
                () -> assertThat(board.getRank(1).getRankRepresentation()).isEqualTo("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("findPiece메서드는 주어진 위치의 piece를 리턴한다.")
    void checkFindPiece() {
        assertAll (
                () -> assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(board.findPiece("b8")).isEqualTo(Piece.createBlackKnight()),
                () -> assertThat(board.findPiece("c8")).isEqualTo(Piece.createBlackBishop()),
                () -> assertThat(board.findPiece("d8")).isEqualTo(Piece.createBlackQueen()),
                () -> assertThat(board.findPiece("e8")).isEqualTo(Piece.createBlackKing()),
                () -> assertThat(board.findPiece("f8")).isEqualTo(Piece.createBlackBishop()),
                () -> assertThat(board.findPiece("g8")).isEqualTo(Piece.createBlackKnight()),
                () -> assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook()),

                () -> assertThat(board.findPiece("e7")).isEqualTo(Piece.createBlackPawn()),

                () -> assertThat(board.findPiece("f2")).isEqualTo(Piece.createWhitePawn()),

                () -> assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook()),
                () -> assertThat(board.findPiece("b1")).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(board.findPiece("c1")).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(board.findPiece("d1")).isEqualTo(Piece.createWhiteQueen()),
                () -> assertThat(board.findPiece("e1")).isEqualTo(Piece.createWhiteKing()),
                () -> assertThat(board.findPiece("f1")).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(board.findPiece("g1")).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook())
        );
    }
}
