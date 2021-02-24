package chess;

import chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_RANK = 8;
    private List<Rank> board = new ArrayList<>(BOARD_RANK);

    public void initializeBoard() {
        // 랭크 번호 순서대로 board 리스트에 담기
        board.add(initWhitePieceRank());
        board.add(initWhitePawnRank());
        for (int i = 0; i < 4; i++) {
            board.add(initBlankRank(i + 3));
        }
        board.add(initBlackPawnRank());
        board.add(initBlackPieceRank());
    }

    private Rank initWhitePieceRank() {
        Rank rank = new Rank(1);
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());

        return rank;
    }

    private Rank initWhitePawnRank() {
        Rank rank = new Rank(2);
        for (int i = 0; i < BOARD_RANK; i++) {
            rank.add(Piece.createWhitePawn());
        }
        return rank;
    }

    private Rank initBlankRank(int rankCount) {
        Rank rank = new Rank(rankCount);
        for (int i = 0; i < BOARD_RANK; i++) {
            rank.add(Piece.createBlank());
        }
        return rank;
    }

    private Rank initBlackPawnRank() {
        Rank rank = new Rank(7);
        for (int i = 0; i < BOARD_RANK; i++) {
            rank.add(Piece.createBlackPawn());
        }
        return rank;
    }

    private Rank initBlackPieceRank() {
        Rank rank = new Rank(8);
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());

        return rank;
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        String empty = appendNewLine(getBlankResult());
        result.append(appendNewLine(getBlackPieceResult()))
                .append(appendNewLine(getBlackPawnResult()))
                .append(empty + empty + empty + empty)
                .append(appendNewLine(getWhitePawnResult()))
                .append(appendNewLine(getWhitePieceResult()));
        return result.toString();
    }

    private String getWhitePieceResult() {
        return getPieceResult(board.get(0));
    }

    private String getWhitePawnResult() {
        return getPieceResult(board.get(1));
    }

    private String getBlankResult() {
        return getPieceResult(board.get(2));
    }

    private String getBlackPawnResult() {
        return getPieceResult(board.get(6));
    }

    private String getBlackPieceResult() {
        return getPieceResult(board.get(7));
    }

    private String getPieceResult(Rank rank) {
        StringBuilder result = new StringBuilder();
        List<Piece> pieceList = rank.getPieceList();
        for (Piece piece : pieceList) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
    }

    public long countPiece(Piece.Color color, Piece.Type type) {
        Optional<Long> result = board.stream().map(x -> x.count(color, type))
                .reduce((a, b) -> a + b);
        return result.get();
    }
}
