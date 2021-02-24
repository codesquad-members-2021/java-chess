package net.jung.chess;

public class Position {
    private int fileIndex;
    private int rankIndex;

    private Position(String position) {
            fileIndex = position.toCharArray()[0]-'a';
            rankIndex = position.toCharArray()[1]-'0';
    }

    public static Position at(String position) throws IllegalArgumentException {
        char[] positionChar = position.toCharArray();
        if( !(position.length()==2
                && isValidFile(positionChar[0])
                && isValidRank(positionChar[1]))) {
            throw new IllegalArgumentException ("a1~h8 범위의 위치를 입력해주세요.");
        }
        return new Position(position);
    }

    private static boolean isValidFile(char fileAlphabet) {
        return (fileAlphabet >= 'a' && fileAlphabet <= 'h');
    }

    private static boolean isValidRank(char rankNum) {
            return (rankNum >='1' && rankNum <= '8');
    }

    public int getFileIndex() {
        return fileIndex;
    }

    public int getRankIndex() {
        return rankIndex;
    }
}
