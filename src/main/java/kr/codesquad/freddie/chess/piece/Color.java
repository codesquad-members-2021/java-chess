package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;

public enum Color {
    WHITE(1, 2) {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toLowerCase();
        }
    }, BLACK(8, 7) {
        @Override
        String getRepresentationBy(String representation) {
            return representation.toUpperCase();
        }
    };

    private int royalInitializationRank;
    private int pawnInitializationRank;

    Color(int royalInitializationRank, int pawnInitializationRank) {
        this.royalInitializationRank = royalInitializationRank;
        this.pawnInitializationRank = pawnInitializationRank;
    }

    abstract String getRepresentationBy(String representation);

    public int getRoyalInitializationIndex() {
        return Board.RANK_SIZE - royalInitializationRank;
    }

    public int getPawnInitializationIndex() {
        return Board.RANK_SIZE - pawnInitializationRank;
    }
}
