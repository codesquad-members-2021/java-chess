package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int MAX_RANK = 8;
    public static final int MAX_FILE = 8;
    public static final int RANK1 = 0;
    public static final int RANK2 = 1;
    public static final int RANK3 = 2;
    public static final int RANK4 = 3;
    public static final int RANK5 = 4;
    public static final int RANK6 = 5;
    public static final int RANK7 = 6;
    public static final int RANK8 = 7;

    List<Rank> board = new ArrayList<>();

    Board() {
        for (int i = 0; i < MAX_FILE; i++) {
            board.add(new Rank());
        }
    }

    public int pieceCount() { // 전체 기물의 개수를 반환한다.
        return board.get(Board.RANK1).size()
                + board.get(Board.RANK2).size()
                + board.get(Board.RANK7).size()
                + board.get(Board.RANK8).size();
    }

    public int pieceCountOf(Piece.Color color, Piece.Type type) {
        int pieceCount = 0;
        for (int i = 0; i < MAX_FILE; i++) {
            pieceCount += board.get(i).pieceCountOf(color, type);

        }
        return pieceCount;
    }

    public Piece findPiece(String position) {
        String[] pos = position.split("");
        int file = pos[0].charAt(0) - 'a';
        int rank = Integer.valueOf(pos[1]) - 1;

        Piece target = board.get(rank).getPieceOf(file);
        return target;
    }

    /* 체스판을 초기화한다. */
    public void initialize() {
        addBlackPieces();
        addBlackPawns();
        addBlank();
        addWhitePawns();
        addWhitePieces();
    }

    private void addBlackPieces() {
        board.get(RANK8).addAll(Arrays.asList(
                Piece.createBlack(Piece.Type.ROOK)
                , Piece.createBlack(Piece.Type.KNIGHT)
                , Piece.createBlack(Piece.Type.BISHOP)
                , Piece.createBlack(Piece.Type.QUEEN)
                , Piece.createBlack(Piece.Type.KING)
                , Piece.createBlack(Piece.Type.BISHOP)
                , Piece.createBlack(Piece.Type.KNIGHT)
                , Piece.createBlack(Piece.Type.ROOK))
        );
    }

    private void addBlackPawns() {
        for (int i = 0; i < Board.MAX_RANK; i++) {
            board.get(Board.RANK7).add(Piece.createBlack(Piece.Type.PAWN));
        }
    }

    private void addBlank() {
        for (int i = 0; i < Board.MAX_RANK; i++) {
            board.get(Board.RANK6).add(Piece.createBlank());
            board.get(Board.RANK5).add(Piece.createBlank());
            board.get(Board.RANK4).add(Piece.createBlank());
            board.get(Board.RANK3).add(Piece.createBlank());
        }
    }

    private void addWhitePawns() {
        for (int i = 0; i < Board.MAX_RANK; i++) {
            board.get(Board.RANK2).add(Piece.createWhite(Piece.Type.PAWN));
        }
    }

    private void addWhitePieces() {
        board.get(Board.RANK1).addAll(Arrays.asList(
                Piece.createWhite(Piece.Type.ROOK)
                , Piece.createWhite(Piece.Type.KNIGHT)
                , Piece.createWhite(Piece.Type.BISHOP)
                , Piece.createWhite(Piece.Type.QUEEN)
                , Piece.createWhite(Piece.Type.KING)
                , Piece.createWhite(Piece.Type.BISHOP)
                , Piece.createWhite(Piece.Type.KNIGHT)
                , Piece.createWhite(Piece.Type.ROOK))
        );
    }

    /* 체스판의 결과를 StringBuilder에 저장한 후 String으로 반환한다. */
    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();

        chessBoard.append(appendNewLine(getBlackPieceResult(board.get(Board.RANK8)) + "  8 (rank 8)"))
                .append(appendNewLine(getBlackPieceResult(board.get(Board.RANK7)) + "  7"))
                .append(appendNewLine(getBlankResult(board.get(Board.RANK6)) + "  6"))
                .append(appendNewLine(getBlankResult(board.get(Board.RANK5)) + "  5"))
                .append(appendNewLine(getBlankResult(board.get(Board.RANK4)) + "  4"))
                .append(appendNewLine(getBlankResult(board.get(Board.RANK3)) + "  3"))
                .append(appendNewLine(getWhitePieceResult(board.get(Board.RANK2)) + "  2"))
                .append(appendNewLine(getWhitePieceResult(board.get(Board.RANK1)) + "  1 (rank 1)"))
                .append(appendNewLine(" "))
                .append("abcdefgh");

        return chessBoard.toString();
    }

    private String getBlackPieceResult(final Rank rank) {
        StringBuilder piecesRepresentations = new StringBuilder();
        rank.pieces().forEach(
                piece -> piecesRepresentations.append(piece.getType().getBlackRepresentation()));
        return piecesRepresentations.toString();
    }

    private String getWhitePieceResult(final Rank rank) {
        StringBuilder piecesRepresentations = new StringBuilder();
        rank.pieces().forEach(
                piece -> piecesRepresentations.append(piece.getType().getWhiteRepresentation()));
        return piecesRepresentations.toString();
    }

    private String getBlankResult(final Rank rank) {
        StringBuilder piecesRepresentations = new StringBuilder();
        rank.pieces().forEach(
                piece -> piecesRepresentations.append(piece.getType().getRepresentation()));
        return piecesRepresentations.toString();
    }
}
