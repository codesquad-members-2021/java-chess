package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.Board;

public class PositionConverter {
    private char fileIndex;
    private int rankIndex;

    private PositionConverter(char fileIndex, int rankIndex) {
        this.fileIndex = fileIndex;
        this.rankIndex = rankIndex;
    }

    public static PositionConverter createBy(String position) {
        char fileIndex = position.charAt(0);
        int rankIndex = Character.getNumericValue(position.charAt(1));

        if (fileIndex < 'a' || 'h' < fileIndex) {
            throw new IllegalArgumentException("올바른 fileIndex가 아닙니다. position : " + position);
        }

        if (rankIndex < 1 || Board.RANK_SIZE < rankIndex) {
            throw new IllegalArgumentException("올바른 rankIndex가 아닙니다. position : " + position);
        }

        return new PositionConverter(fileIndex, rankIndex);
    }

    public char getFileIndex() {
        return fileIndex;
    }

    public int getRankIndex() {
        return rankIndex;
    }

    public int getFileIndexForList() {
        return fileIndex - 'a';
    }

    public int getRankIndexForList() {
        return Board.RANK_SIZE - rankIndex;
    }
}
