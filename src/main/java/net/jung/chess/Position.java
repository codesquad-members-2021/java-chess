package net.jung.chess;

public class Position {
    private int fileIndex;
    private int rankIndex;

    private Position(String location) {
        fileIndex = location.toCharArray()[0] - 'a';
        rankIndex = location.toCharArray()[1] - '0';
    }

    public static Position at(String location) throws IllegalArgumentException {
        char[] positionChar = location.toCharArray();
        if (!(location.length() == 2
                && isValidFile(positionChar[0])
                && isValidRank(positionChar[1]))) {
            throw new IllegalArgumentException("a1~h8 범위의 위치를 입력해주세요.");
        }
        return new Position(location);
    }

    private static boolean isValidFile(char fileAlphabet) {
        return (fileAlphabet >= 'a' && fileAlphabet <= 'h');
    }

    private static boolean isValidRank(char rankNum) {
        return (rankNum >= '1' && rankNum <= '8');
    }

    public int getFileIndex() {
        return fileIndex;
    }

    public int getRankIndex() {
        return rankIndex;
    }

    public boolean isCertainFile(int index) {
        return getFileIndex() == index ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null & obj instanceof Position) {
            Position positionObj = (Position) obj;
            boolean compareFileIndex = fileIndex == positionObj.fileIndex;
            boolean compareRankIndex = rankIndex == positionObj.rankIndex;
            return compareFileIndex && compareRankIndex;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return fileIndex + rankIndex;
    }
}


