package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import static net.eno.utils.StringUtils.appendNewLine;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("초기화 된 보드의 기물의 개수가 32개여야 한다.")
    public void size() {
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("타입 별 기물의 개수가 일치해야 한다.")
    public void count() {
        PieceType[] pieceTypeArray = PieceType.values();
        for (int i = 0; i < pieceTypeArray.length; i++) {
            if (i != 6) {
                assertThat(board.targetPieceCount(Color.WHITE, pieceTypeArray[i])).isEqualTo(pieceCount(pieceTypeArray[i]));
                assertThat(board.targetPieceCount(Color.BLACK, pieceTypeArray[i])).isEqualTo(pieceCount(pieceTypeArray[i]));
            } else {
                assertThat(board.targetPieceCount(Color.NOCOLOR, pieceTypeArray[i])).isEqualTo(pieceCount(pieceTypeArray[i]));
            }
        }
    }

    private int pieceCount(PieceType pieceType) {
        switch (pieceType) {
            case NO_PIECE :
                return 32;
            case PAWN :
                return 8;
            case KING : case QUEEN :
                return 1;
            default :
                return 2;
        }
    }

    @Test
    @DisplayName("초기화 된 보드의 기물의 배치가 일치해야 한다.")
    public void initialize() {
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard(Color.WHITE)).isEqualTo(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr")
        );
        assertThat(board.showBoard(Color.BLACK)).isEqualTo(
                appendNewLine("rnbkqbnr") +
                appendNewLine("pppppppp") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("PPPPPPPP") +
                appendNewLine("RNBKQBNR")
        );
    }

    @Test
    @DisplayName("체스판에 해당하는 좌표의 기물을 가져올 수 있어야 한다.")
    public void findPiece() {
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createPiece(Color.BLACK, PieceType.ROOK, new Position("a8")));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createPiece(Color.BLACK, PieceType.ROOK, new Position("h8")));
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createPiece(Color.WHITE, PieceType.ROOK, new Position("a1")));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createPiece(Color.WHITE, PieceType.ROOK, new Position("h1")));
    }

    @Test
    @DisplayName("체스판에 임의의 기물을 추가할 수 있어야 한다.")
    public void move() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createPiece(Color.BLACK, PieceType.ROOK, new Position(position));
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard(Color.WHITE));
    }

}
