package net.jung.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.jung.chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    private Board board;
    private String BLANK_RANK = appendNewLine("********");

    private Board emptyBoard;
    private Board halfEmptyBoard;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.initialize();

        emptyBoard = new Board();
        emptyBoard.initializeEmptyBoard();

        halfEmptyBoard = new Board();
        halfEmptyBoard.initializeEmptyBoard();
        halfEmptyBoard.addNewPiece(Position.at("f2"), Piece.createWhitePawn());
        halfEmptyBoard.addNewPiece(Position.at("g2"), Piece.createWhitePawn());
        halfEmptyBoard.addNewPiece(Position.at("a2"), Piece.createWhiteQueen());
        halfEmptyBoard.addNewPiece(Position.at("e1"), Piece.createWhiteRook());
        halfEmptyBoard.addNewPiece(Position.at("f1"), Piece.createWhiteKing());

        halfEmptyBoard.addNewPiece(Position.at("b6"), Piece.createBlackPawn());
        halfEmptyBoard.addNewPiece(Position.at("e6"), Piece.createBlackQueen());
        halfEmptyBoard.addNewPiece(Position.at("b8"), Piece.createBlackKing());
        halfEmptyBoard.addNewPiece(Position.at("a8"), Piece.createBlackBishop());
        halfEmptyBoard.addNewPiece(Position.at("c8"), Piece.createBlackRook());
    }


    @Test
    @DisplayName("initialize()는 32개 모든 말을 체스판 위에 올린다.")
    void initializeAddsEveryPiece() {
        int maxNumOfPieces = 32;

        assertAll(
                () -> assertThat(board.boardPieceSize()).isEqualTo(maxNumOfPieces),
                () -> assertThat(board.boardLayoutToString()).isEqualTo(
                        appendNewLine("RNBQKBNR")
                                + appendNewLine("PPPPPPPP")
                                + BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK
                                + appendNewLine("pppppppp")
                                + appendNewLine("rnbqkbnr"))
        );
    }

    @Test
    @DisplayName("certainPieceSize는 보드 위의 특정 색/타입의 피스 개수를 리턴한다")
    void checkCertainPieceSize() {
        int pawnSize = 8;
        int nonRoyalSize = 2;
        int royalSize = 1;
        assertAll(
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
                () -> assertThat(board.getRank(8).rankLayoutToString()).isEqualTo("RNBQKBNR"),
                () -> assertThat(board.getRank(7).rankLayoutToString()).isEqualTo("PPPPPPPP"),
                () -> assertThat(board.getRank(6).rankLayoutToString()).isEqualTo("********"),
                () -> assertThat(board.getRank(2).rankLayoutToString()).isEqualTo("pppppppp"),
                () -> assertThat(board.getRank(1).rankLayoutToString()).isEqualTo("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("findPiece메서드는 주어진 위치의 piece를 리턴한다.")
    void checkFindPiece() {
        assertAll(
                () -> assertThat(board.findPiece(Position.at("a8"))).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(board.findPiece(Position.at("b8"))).isEqualTo(Piece.createBlackKnight()),
                () -> assertThat(board.findPiece(Position.at("c8"))).isEqualTo(Piece.createBlackBishop()),
                () -> assertThat(board.findPiece(Position.at("d8"))).isEqualTo(Piece.createBlackQueen()),
                () -> assertThat(board.findPiece(Position.at("e8"))).isEqualTo(Piece.createBlackKing()),
                () -> assertThat(board.findPiece(Position.at("f8"))).isEqualTo(Piece.createBlackBishop()),
                () -> assertThat(board.findPiece(Position.at("g8"))).isEqualTo(Piece.createBlackKnight()),
                () -> assertThat(board.findPiece(Position.at("h8"))).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(board.findPiece(Position.at("e7"))).isEqualTo(Piece.createBlackPawn()),

                () -> assertThat(board.findPiece(Position.at("f2"))).isEqualTo(Piece.createWhitePawn()),

                () -> assertThat(board.findPiece(Position.at("a1"))).isEqualTo(Piece.createWhiteRook()),
                () -> assertThat(board.findPiece(Position.at("b1"))).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(board.findPiece(Position.at("c1"))).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(board.findPiece(Position.at("d1"))).isEqualTo(Piece.createWhiteQueen()),
                () -> assertThat(board.findPiece(Position.at("e1"))).isEqualTo(Piece.createWhiteKing()),
                () -> assertThat(board.findPiece(Position.at("f1"))).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(board.findPiece(Position.at("g1"))).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(board.findPiece(Position.at("h1"))).isEqualTo(Piece.createWhiteRook())
        );
    }

    @Test
    @DisplayName("initializeEmptyBoard는 보드에 NO_PIECE만 있다.")
    void checkInitializeEmptyBoard() {

        assertAll(
                () -> assertThat(emptyBoard.boardLayoutToString()).isEqualTo(
                        BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK
                                + BLANK_RANK),
                () -> assertThat(emptyBoard.boardPieceSize()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("addOnePiece는 특정 자리에 (기존에 있던 것이 아닌) 새로만들어진 piece를 추가한다.")
    void checkAddNewPiece() {

        emptyBoard.addNewPiece(Position.at("d3"), Piece.createBlackRook());
        emptyBoard.addNewPiece(Position.at("d7"), Piece.createWhiteKing());

        assertAll(
                () -> assertThat(emptyBoard.findPiece(Position.at("d3"))).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(emptyBoard.findPiece(Position.at("d7"))).isEqualTo(Piece.createWhiteKing())
        );
    }

    @Test
    @DisplayName("movePiece는 특정지점에서 piece가 발견되면 다른 지점으로 옮긴다.")
    void checkMovePiece() {
        board.movePiece(Position.at("a8"), Position.at("c4"));

        assertAll(
                () -> assertThat(board.findPiece(Position.at("a8"))).isEqualTo(Piece.createBlank()),
                () -> assertThat(board.findPiece(Position.at("c4"))).isEqualTo(Piece.createBlackRook())
        );
    }

    @Test
    @DisplayName("sameFilePawnSize는 같은 파일에 있는 pawn개수를 반환한다.")
    void checkPawnSizeInFile() {

        emptyBoard.addNewPiece(Position.at("a8"), Piece.createBlackPawn());
        emptyBoard.addNewPiece(Position.at("b8"), Piece.createBlackPawn());
        emptyBoard.addNewPiece(Position.at("c8"), Piece.createBlackPawn());
        emptyBoard.addNewPiece(Position.at("d8"), Piece.createBlackPawn());

        emptyBoard.addNewPiece(Position.at("a7"), Piece.createWhitePawn());
        emptyBoard.addNewPiece(Position.at("a6"), Piece.createWhitePawn());
        emptyBoard.addNewPiece(Position.at("a5"), Piece.createWhitePawn());
        emptyBoard.addNewPiece(Position.at("a4"), Piece.createWhitePawn());

        assertAll(
                () -> assertThat(emptyBoard.pawnSizeInFile(Piece.Color.BLACK)).isEqualTo(0),
                () -> assertThat(emptyBoard.pawnSizeInFile(Piece.Color.WHITE)).isEqualTo(4)
        );
    }


    @Test
    @DisplayName("calculatePoints는 점수 계산한다.")
    void checkCalculatePoints() {

        emptyBoard.addNewPiece(Position.at("f2"), Piece.createWhitePawn());
        emptyBoard.addNewPiece(Position.at("g2"), Piece.createWhitePawn());
        emptyBoard.addNewPiece(Position.at("e1"), Piece.createWhiteRook());
        emptyBoard.addNewPiece(Position.at("f1"), Piece.createWhiteKing());

        emptyBoard.addNewPiece(Position.at("b6"), Piece.createBlackPawn());
        emptyBoard.addNewPiece(Position.at("e6"), Piece.createBlackQueen());
        emptyBoard.addNewPiece(Position.at("b8"), Piece.createBlackKing());
        emptyBoard.addNewPiece(Position.at("c8"), Piece.createBlackRook());

        assertAll(
                () -> assertThat(emptyBoard.calculatePoints(Piece.Color.WHITE)).isEqualTo(7),
                () -> assertThat(emptyBoard.calculatePoints(Piece.Color.BLACK)).isEqualTo(15)
        );
    }

    @Test
    @DisplayName("sortColorPiecesAscending은 오름차순으로 정렬한다.")
    void checkSortColorPiecesAscending() {
        List<Piece> whitePieces = halfEmptyBoard.sortColorPiecesAscending(Piece.Color.WHITE);
        List<Piece> blackPieces = halfEmptyBoard.sortColorPiecesAscending(Piece.Color.BLACK);

        assertAll(
                () -> assertThat(whitePieces.get(4)).isEqualTo(Piece.createWhiteQueen()),
                () -> assertThat(whitePieces.get(3)).isEqualTo(Piece.createWhiteRook()),

                () -> assertThat(blackPieces.get(4)).isEqualTo(Piece.createBlackQueen()),
                () -> assertThat(blackPieces.get(3)).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(blackPieces.get(2)).isEqualTo(Piece.createBlackBishop())
        );
    }

    @Test
    @DisplayName("sortColorPiecesDescending은 내림차순으로 정렬한다.")
    void checkSortColorPiecesDescending() {
        List<Piece> whitePieces = halfEmptyBoard.sortColorPiecesDescending(Piece.Color.WHITE);
        List<Piece> blackPieces = halfEmptyBoard.sortColorPiecesDescending(Piece.Color.BLACK);

        assertAll(
                () -> assertThat(whitePieces.get(0)).isEqualTo(Piece.createWhiteQueen()),
                () -> assertThat(whitePieces.get(1)).isEqualTo(Piece.createWhiteRook()),

                () -> assertThat(blackPieces.get(0)).isEqualTo(Piece.createBlackQueen()),
                () -> assertThat(blackPieces.get(1)).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(blackPieces.get(2)).isEqualTo(Piece.createBlackBishop())
        );

    }
}
