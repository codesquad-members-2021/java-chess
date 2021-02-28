package net.jung.chess;

public class Position {
    private static final int NUM_OF_DIGITS = 2;
    private final int FILE_INDEX;
    private final int RANK_INDEX;

    private Position(String location) {
        FILE_INDEX = location.toCharArray()[0] - 'a';
        RANK_INDEX = location.toCharArray()[1] - '0';
    }

    public static Position at(String location) throws IllegalArgumentException {
        char[] positionChar = location.toCharArray();
        if (!(location.length() == NUM_OF_DIGITS
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
        return FILE_INDEX;
    }

    public int getRankIndex() {
        return RANK_INDEX;
    }

    public boolean isCertainFile(int index) {
        return getFileIndex() == index ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null & obj instanceof Position) {
            Position positionObj = (Position) obj;
            boolean compareFileIndex = FILE_INDEX == positionObj.FILE_INDEX;
            boolean compareRankIndex = RANK_INDEX == positionObj.RANK_INDEX;
            return compareFileIndex && compareRankIndex;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return FILE_INDEX + RANK_INDEX;
    }
}


