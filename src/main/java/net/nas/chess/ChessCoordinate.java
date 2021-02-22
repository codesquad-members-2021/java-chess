package net.nas.chess;

public class ChessCoordinate {
    public final int rankIndex;
    public final int fileIndex;

    protected ChessCoordinate(int rankIndex, int fileIndex) {
        this.rankIndex = rankIndex;
        this.fileIndex = fileIndex;
    }
}
