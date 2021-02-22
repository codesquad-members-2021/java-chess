package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.Board;

public class RankIndexConverter {
    private int rankIndex;

    public RankIndexConverter(int rankIndex) {
        if (rankIndex < 1 || Board.RANK_SIZE < rankIndex) {
            throw new IllegalArgumentException("올바른 rankIndex가 아닙니다. rankIndex : " + rankIndex);
        }

        this.rankIndex = rankIndex;
    }

    public int getRankIndex() {
        return rankIndex;
    }

    public int getRankIndexForList() {
        return Board.RANK_SIZE - rankIndex;
    }
}
