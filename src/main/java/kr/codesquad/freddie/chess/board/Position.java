package kr.codesquad.freddie.chess.board;

public class Position {
    private FileIndex fileIndex;
    private RankIndex rankIndex;

    public Position(FileIndex fileIndex, RankIndex rankIndex) {
        this.fileIndex = fileIndex;
        this.rankIndex = rankIndex;
    }

    public static Position of(String position) {
        char fileIndex = position.charAt(0);
        int rankIndex = Character.getNumericValue(position.charAt(1));
        return new Position(new FileIndex(fileIndex), new RankIndex(rankIndex));
    }

    public char getFileIndex() {
        return fileIndex.getFileIndex();
    }

    public int getRankIndex() {
        return rankIndex.getRankIndex();
    }

    public int getFileIndexForList() {
        return fileIndex.getFileIndexForList();
    }

    public int getRankIndexForList() {
        return rankIndex.getRankIndexForList();
    }
}
