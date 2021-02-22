package kr.codesquad.freddie.chess.utils;

public class PositionConverter {
    private FileIndexConverter fileIndexConverter;
    private RankIndexConverter rankIndexConverter;

    public PositionConverter(FileIndexConverter fileIndexConverter, RankIndexConverter rankIndexConverter) {
        this.fileIndexConverter = fileIndexConverter;
        this.rankIndexConverter = rankIndexConverter;
    }

    public static PositionConverter createBy(String position) {
        char fileIndex = position.charAt(0);
        int rankIndex = Character.getNumericValue(position.charAt(1));
        return new PositionConverter(new FileIndexConverter(fileIndex), new RankIndexConverter(rankIndex));
    }

    public char getFileIndex() {
        return fileIndexConverter.getFileIndex();
    }

    public int getRankIndex() {
        return rankIndexConverter.getRankIndex();
    }

    public int getFileIndexForList() {
        return fileIndexConverter.getFileIndexForList();
    }

    public int getRankIndexForList() {
        return rankIndexConverter.getRankIndexForList();
    }
}
