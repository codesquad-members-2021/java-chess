package chess;

import chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_RANK = 8;
    private List<Rank> board = new ArrayList<>(BOARD_RANK);

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_RANK; i++) {
            board.add(initBlankRank(i + 1));
        }
    }

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
        for (int i = BOARD_RANK - 1; i >= 0; i--) {
            result.append(appendNewLine(getRankResult(i)));
        }
        return result.toString();
    }

    private String getRankResult(int index) {
        return getPieceResult(board.get(index));
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

    public Piece findPiece(String position) {
        int x = getX(position);
        int y = getY(position);
        return board.get(y).getPieceList().get(x);
    }

    public void setPiece(String position, Piece piece) {
        int x = getX(position);
        int y = getY(position);
        board.get(y).remove(x);
        board.get(y).setPiece(x, piece);
    }

    private int getX(String position){
        return position.charAt(0) - 'a';
    }

    private int getY(String position){
        return position.charAt(1) - '0' - 1;
    }
}
