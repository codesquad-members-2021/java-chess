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

    public int pieceCount() {
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

    public void putPieceIn(String position, Piece piece) {
        String[] pos = position.split("");
        int file = pos[0].charAt(0) - 'a';
        int rank = Integer.valueOf(pos[1]) - 1;
        board.get(rank).set(file, piece);
    }

    public void initialize() {
        addBlackPieces();
        addBlackPawns();
        addBlank();
        addWhitePawns();
        addWhitePieces();
    }

    public void initializeEmpty() {
        for (int i = 0; i < MAX_RANK; i++) {
            board.set(i, getBlankRank());
        }
    }

    private Rank getBlankRank() {
        Rank rank = new Rank();
        for (int i = 0; i < MAX_FILE; i++) {
            rank.add(Piece.createBlank());
        }
        return rank;
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

        chessBoard.append(appendNewLine(getRankResult(board.get(Board.RANK8)) + "  8 (rank 8)"))
                .append(appendNewLine(getRankResult(board.get(Board.RANK7)) + "  7"))
                .append(appendNewLine(getRankResult(board.get(Board.RANK6)) + "  6"))
                .append(appendNewLine(getRankResult(board.get(Board.RANK5)) + "  5"))
                .append(appendNewLine(getRankResult(board.get(Board.RANK4)) + "  4"))
                .append(appendNewLine(getRankResult(board.get(Board.RANK3)) + "  3"))
                .append(appendNewLine(getRankResult(board.get(Board.RANK2)) + "  2"))
                .append(appendNewLine(getRankResult(board.get(Board.RANK1)) + "  1 (rank 1)"))
                .append(appendNewLine(" "))
                .append("abcdefgh");

        return chessBoard.toString();
    }

    private String getRankResult(final Rank rank) {
        StringBuilder piecesRepresentations = new StringBuilder();
        char representation = ' ';
        for (int i = 0; i < rank.pieces().size(); i++) {
            Piece piece = rank.pieces().get(i);
            if (piece.getColor() == Piece.Color.BLACK) {
                representation = piece.getType().getBlackRepresentation();
            } else {
                representation = piece.getType().getWhiteRepresentation();
            }
            piecesRepresentations.append(representation);
        }
        return piecesRepresentations.toString();
    }

    public double calculatePoint(Piece.Color color) {
        double point = 0;
        List<Integer> filesOfPawnsInAboveRank = new ArrayList<>();
        for (Rank rank : board) {
            point += rank.calculatePoint(color);
            double doublePawn = getDoublePawn(filesOfPawnsInAboveRank, rank.getFilesOfPawns(color));
            point -= doublePawn;
            filesOfPawnsInAboveRank = rank.getFilesOfPawns(color);
        }
        return point;
    }

    /**
     *  2개 이상 pawn이 중첩될 경우 각 pawn을 0.5점으로 계산해야되는데,
     *  현재 로직은 2개 이상이어도 무조건 1을 반환한다.
     */
    private double getDoublePawn(List<Integer> filesOfPawnsInAboveRank, List<Integer> filesOfPawns) {
        if (filesOfPawnsInAboveRank.size() == 0) return 0;
        if (filesOfPawns.size() == 0) return 0;

        double doublePawn = 0;

        if (filesOfPawnsInAboveRank.size() > filesOfPawns.size()) {
            for (int i = 0; i < filesOfPawns.size(); i++) {
                if (filesOfPawnsInAboveRank.contains(filesOfPawns.get(i))) {
                    doublePawn += 1;
                }
            }
        } else {
            for (int i = 0; i < filesOfPawnsInAboveRank.size(); i++) {
                if (filesOfPawns.contains(filesOfPawnsInAboveRank.get(i))) {
                    doublePawn += 1;
                }
            }
        }
        return doublePawn;
    }
}
